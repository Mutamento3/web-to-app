# Fullscreen Mode

Runs the app immersive, hiding the system bars and (optionally) working together with the browser-toolbar setting.

**Where:** the **Fullscreen mode** card in the [Edit Common Config](/guide/app-actions/edit-common-config/) editor.

## Options

- **Fullscreen** — enable immersive fullscreen (`hideToolbar`).
- **Show status bar in fullscreen** — keep the top status bar visible (`showStatusBarInFullscreen`).
- **Show navigation bar in fullscreen** — keep the bottom navigation bar visible (`showNavigationBarInFullscreen`).
- **Fullscreen content padding** — inset content by a number of dp (`fullscreenContentPaddingDp`).
- **Status bar style** — an expandable sub-panel (`statusBarStyleConfigLabel`) with light/dark tabs: color mode (`THEME`/`PAGE_TOP`/`TRANSPARENT`/`CUSTOM`), custom color, dark icons, and background (color/image) for each mode.

## Interaction with the browser toolbar

Whether the in-app toolbar shows during fullscreen is governed by the [Browser Toolbar](/guide/app-actions/edit-common-config/browser-toolbar) master switch and the `showToolbarInFullscreen` flag (`hideToolbar = !browserToolbarEnabled || !showToolbarInFullscreen` at runtime). Note the toolbar is off by default, so a freshly exported app has no toolbar in or out of fullscreen.

## Notes

- When the status bar is visible, the splash countdown/skip chip sits below it so it is never covered.
- Fullscreen **video** orientation (landscape/sensor for fullscreen video playback, `fullscreenVideoOrientation`) is configured under [Special Settings](/guide/app-actions/edit-common-config/special-settings).
- Keyboard-avoidance behavior below Android 11 uses the classic window-resize path; see [Special Settings](/guide/app-actions/edit-common-config/special-settings) for the keyboard adjust mode.
