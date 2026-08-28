package com.webtoapp.data.model

/**
 * Resolved visibility of each toolbar control in the shell/preview browser toolbar.
 *
 * Semantics: the "hide browser toolbar" toggle (`hideBrowserToolbar`) switches the
 * toolbar into a customized slim mode where only the explicitly-checked items
 * (`toolbarShow*`) appear. In the normal mode (`hideBrowserToolbar = false`) the
 * toolbar always shows the full button set — the `toolbarShow*` checkboxes are only
 * editable while the hide toggle is on, so their values must not be applied in the
 * normal mode (doing so leaves a toolbar with every button hidden once the toggle is
 * turned back off).
 */
data class ToolbarButtonVisibility(
    val showTitle: Boolean,
    val showUrl: Boolean,
    val showBack: Boolean,
    val showForward: Boolean,
    val showRefresh: Boolean,
    val showConsoleButton: Boolean,
    val showFind: Boolean
)

/**
 * Whether the customized slim toolbar has at least one item to render. Console is a
 * toolbar item in its own right: a toolbar customized down to only that button
 * must still render. Both the host preview and the exported shell gate the slim
 * toolbar on this predicate — keep them on the shared function so the two paths
 * cannot drift apart again. The console/find flags have NO defaults on purpose:
 * every caller must pass them explicitly, so a new flag can never be silently
 * treated as "on" by one path and not the other.
 */
fun hasAnySlimToolbarItem(
    toolbarShowTitle: Boolean,
    toolbarShowUrl: Boolean,
    toolbarShowBack: Boolean,
    toolbarShowForward: Boolean,
    toolbarShowRefresh: Boolean,
    toolbarShowConsole: Boolean,
    toolbarShowFind: Boolean
): Boolean = toolbarShowTitle || toolbarShowUrl || toolbarShowBack || toolbarShowForward ||
    toolbarShowRefresh || toolbarShowConsole || toolbarShowFind

/**
 * Resolves which toolbar buttons are visible given the hide-toggle state and the
 * customized toolbar content flags. See [ToolbarButtonVisibility] for the contract.
 * The console/find flags have NO defaults on purpose — same anti-drift rule as
 * [hasAnySlimToolbarItem].
 */
fun resolveToolbarButtons(
    hideBrowserToolbar: Boolean,
    browserToolbarCustomized: Boolean,
    toolbarShowTitle: Boolean,
    toolbarShowUrl: Boolean,
    toolbarShowBack: Boolean,
    toolbarShowForward: Boolean,
    toolbarShowRefresh: Boolean,
    toolbarShowConsole: Boolean,
    toolbarShowFind: Boolean
): ToolbarButtonVisibility {
    val customizedSlim = hideBrowserToolbar && browserToolbarCustomized
    return ToolbarButtonVisibility(
        showTitle = !customizedSlim || toolbarShowTitle,
        showUrl = !customizedSlim || toolbarShowUrl,
        showBack = !customizedSlim || toolbarShowBack,
        showForward = !customizedSlim || toolbarShowForward,
        showRefresh = !customizedSlim || toolbarShowRefresh,
        showConsoleButton = !customizedSlim || toolbarShowConsole,
        showFind = !customizedSlim || toolbarShowFind
    )
}
