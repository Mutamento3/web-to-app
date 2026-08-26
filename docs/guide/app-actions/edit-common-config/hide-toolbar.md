# Hide Browser Toolbar

Controls the in-app browser toolbar (the bar with back/forward/refresh/title/URL).

**Where:** the **Hide browser toolbar** card in the [Edit Common Config](/guide/app-actions/edit-common-config/) editor.

## Options

- **Hide browser toolbar** — hide the toolbar entirely (`hideBrowserToolbar`).
- When you enable hiding for the first time, the individual toolbar items are turned off and marked as customized.
- **Toolbar items** — independently toggle what the toolbar shows:
  - show title (`toolbarShowTitle`)
  - show URL (`toolbarShowUrl`)
  - show back (`toolbarShowBack`)
  - show forward (`toolbarShowForward`)
  - show refresh (`toolbarShowRefresh`)
  - show console button (`toolbarShowConsole`)
  - show page-zoom button (`toolbarShowZoom`)
  - show find-in-page button (`toolbarShowFind`)

## Runtime toolbar controls

These panels open **from the toolbar at runtime** (inside the generated APK or the host preview). Their toolbar buttons are gated by the build-time items above — hide the item and the button disappears:

- **Page zoom** — a toolbar action opens a preset picker (50% / 67% / 75% / 80% / 90% / 100% / 110% / 125% / 150%, mirroring Chrome's stops). The chosen zoom is saved **per app** (by package name) and re-applied on cold start without a page reload. Separate from the build-time [Zoom](/guide/app-actions/edit-common-config/advanced-settings) toggle.
- **Console** — a toolbar button opens a console panel showing `console.log` / error output. Useful for debugging the loaded page at runtime.
- **Find in page** — a toolbar button opens a native bottom search bar with live match counting and previous/next navigation, powered by the WebView engine (`findAllAsync`).

## Notes

- For hiding the system status/navigation bars, see [Fullscreen Mode](/guide/app-actions/edit-common-config/fullscreen).
- A floating back button can be enabled under [Special Settings](/guide/app-actions/edit-common-config/special-settings).
