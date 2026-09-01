# Special Settings

Compatibility polyfills, bridges, and other specialized toggles. This card collects the specialized `WebViewConfig` options.

**Where:** the **Special settings** card in the [Edit Common Config](/guide/app-actions/edit-common-config/) editor.

## Polyfills & bridges

- **Clipboard polyfill** — `enableClipboardPolyfill`.
- **Notification polyfill** — Web Notification support (`enableNotificationPolyfill`).
- **Orientation polyfill** — `enableOrientationPolyfill`.
- **Compat polyfills** — a bundle of compatibility shims (`enableCompatPolyfills`).
- **Native bridge** — expose a native bridge with capability gates (`enableNativeBridge`, `nativeBridgeCapabilities`).
- **Print bridge** — intercept `window.print()` and PDF output to the Android print framework (`enablePrintBridge`).
- **Media Session bridge** — bridge web media to the system media notification and lock-screen controls, including Bluetooth headsets and Android Auto (`enableMediaSession`).
- **Share bridge** — `enableShareBridge`.
- **Zoom polyfill** — `enableZoomPolyfill`.

## Media & content

- **Media autoplay** — with scope (`mediaAutoplayEnabled`, `mediaAutoplayScope`: video-only, …).
- **Image repair** — fix broken images (`enableImageRepair`).
- **Scroll memory** — remember scroll position (`enableScrollMemory`).
- **Back-state preservation** — `enableBackStatePreservation`.
- **Blob download interception** — with scope and size threshold (`enableBlobDownloadInterception`, `blobInterceptThresholdMb`).

## JavaScript & windows

- **JS can open windows** — with policy (`javaScriptCanOpenWindows`, `jsOpenWindowsPolicy`).
- **Prime user activation** — synthesize a user gesture, with mode and timing (`primeUserActivation`, `primeUserActivationMode`, `primeUserActivationTiming`).
- **Base64 deep links** — decode base64 deep links, gesture-only or always (`decodeBase64DeepLinks`, `decodeBase64Mode`).

## Security & misc

- **Cross-origin isolation** — `enableCrossOriginIsolation`.
- **Anti-capture** — block screen capture (`antiCapture`).
- **Hide status bar in video fullscreen** — force-hide the status bar while a web video plays in HTML5 fullscreen, restoring it on exit (`hideStatusBarInVideoFullscreen`, on by default). Overrides the [Fullscreen Mode](/guide/app-actions/edit-common-config/fullscreen) "show status bar in fullscreen" option while the video holds the screen.
- **File access from file URLs** — `allowFileAccessFromFileURLs`, `allowUniversalAccessFromFileURLs`.
- **Error page** — custom error page config (`errorPageConfig`).
- **Performance optimization** — `performanceOptimization`.
- **PWA offline** — offline cache strategy (`pwaOfflineEnabled`, `pwaOfflineStrategy`).
- **Floating back button** — `showFloatingBackButton`.
- **Keyboard adjust mode** — `keyboardAdjustMode` (resize, …). On Android 10 and below, the RESIZE mode uses the classic window-resize path (the window is not edge-to-edge), so the keyboard resizes content reliably.
- **Fullscreen video orientation** — how fullscreen video orients (`fullscreenVideoOrientation`), e.g. auto sensor landscape.
- **Hide URL preview** — `hideUrlPreview`.

## Notes

- These are power-user toggles; most apps leave them at defaults.
