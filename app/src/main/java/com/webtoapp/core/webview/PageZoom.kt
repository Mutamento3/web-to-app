package com.webtoapp.core.webview

import android.webkit.WebView
import com.webtoapp.core.logging.AppLogger

/**
 * Browser-level page zoom (#654). Scales the whole page — text, images and layout boxes
 * together, like Chrome/Edge page zoom — by setting CSS `zoom` on the document element.
 *
 * This deliberately replaces the previous mechanism ([WebSettings.setTextZoom]) for
 * overrides: textZoom re-renders only glyphs and never touches media or spacing, which is
 * exactly what #654 reported. CSS zoom on :root reflows the whole layout, and mobile
 * WebViews have shipped it (non-standard but universally supported by Chromium) for years,
 * down to old provider builds.
 *
 * Two zoom sources compose:
 *  - Build-time default: [com.webtoapp.data.model.WebViewConfig.initialPageZoomPercent]
 *    chosen in the editor, embedded into shell config.
 *  - Runtime override: [PageZoomStore] value set from the toolbar dialog at app runtime;
 *    wins over the build-time default when present (>0).
 *
 * The resolved percent is applied on every onPageFinished (idempotent), so it survives
 * client redirects and same-Window navigations; live changes from the toolbar apply the
 * script immediately to the current DOM instead of forcing a reload (CSS zoom relayouts
 * synchronously). GeckoView has no WebView settings surface — callers gate on engine type
 * and this object stays inert there.
 */
object PageZoom {

    const val DEFAULT_PERCENT = 100

    /** Chrome-like stops; anything outside is clamped rather than rejected. */
    const val MIN_PERCENT = 25
    const val MAX_PERCENT = 300

    fun normalize(percent: Int): Int = percent.coerceIn(MIN_PERCENT, MAX_PERCENT)

    /**
     * Effective percent for a freshly created/loaded WebView: a stored runtime override
     * (>0) always wins over the build-time default.
     */
    fun resolvePercent(configuredPercent: Int, runtimeOverridePercent: Int): Int {
        if (runtimeOverridePercent > 0) return normalize(runtimeOverridePercent)
        if (configuredPercent > 0 && configuredPercent != DEFAULT_PERCENT) {
            return normalize(configuredPercent)
        }
        return DEFAULT_PERCENT
    }

    /**
     * JS that applies [percent] to the loaded document. Pass [DEFAULT_PERCENT] to clear any
     * previously applied zoom. Idempotent; safe to evaluate repeatedly on the same page.
     */
    fun jsApplyScript(percent: Int): String {
        if (percent <= 0 || percent == DEFAULT_PERCENT) {
            return "(function(){try{document.documentElement.style.removeProperty('zoom');}catch(e){}})();"
        }
        val p = normalize(percent)
        return "(function(){try{document.documentElement.style.setProperty('zoom','$p%','important');" +
            "if(document.documentElement.style.zoom!=='$p%'){document.documentElement.style.zoom='$p%';}}catch(e){}})();"
    }

    /**
     * Applies [percent] to an already-loaded [webView]. Percent == [DEFAULT_PERCENT] clears
     * any previously applied zoom (needed after a runtime reset); repeated calls with an
     * unchanged percent are skipped via the internal last-applied map so the onPageFinished
     * hook costs nothing on pages that never asked for zoom.
     */
    private val lastAppliedByView = java.util.WeakHashMap<WebView, Int>()

    fun applyToLoaded(webView: WebView?, percent: Int) {
        if (webView == null) return
        val target = if (percent <= 0) DEFAULT_PERCENT else normalize(percent)
        synchronized(lastAppliedByView) {
            if (lastAppliedByView[webView] == target && target != DEFAULT_PERCENT) return
            lastAppliedByView[webView] = target
        }
        try {
            webView.evaluateJavascript(jsApplyScript(target), null)
        } catch (e: Exception) {
            AppLogger.w("PageZoom", "apply failed", e)
        }
    }
}
