---
layout: home

hero:
  name: WebToApp
  text: Build Android APKs on your phone
  tagline: An on-device APK workshop that goes far beyond URL wrapping — fork+exec real server runtimes, ship a hardened anti-censorship network stack, and export Play-ready bundles. No PC, no cloud build queue.
  image:
    src: /logo.png
    alt: WebToApp
  actions:
    - theme: brand
      text: Get Started
      link: /guide/introduction
    - theme: alt
      text: Download APK
      link: https://github.com/shiaho777/web-to-app/releases
    - theme: alt
      text: Developer Docs
      link: /developer/

features:
  - icon: ⚙️
    title: Real on-device runtimes
    details: Node.js, PHP, Python, Go, and WordPress fork+exec as native binaries straight from app storage — like Termux, packaged into an installable APK.
  - icon: 🛡️
    title: Hardened networking
    details: DNS-over-HTTPS, TLS fingerprint spoofing with a local MITM bridge, Encrypted Client Hello (ECH), per-app proxies, and CORS bypass for locked-down SPAs.
  - icon: 📦
    title: Self-contained builds
    details: Binary AXML/ARSC patching, permission pruning, V1/V2/V3 signing, and Google Play-ready AAB export — all inside the app via apksig.
  - icon: 🧩
    title: Extensible after shipping
    details: Add JS/CSS modules, Tampermonkey-style userscripts, or MV3 Chrome extensions (live-searched from the Chrome Web Store) without rebuilding the host.
  - icon: 🔒
    title: Privacy & fingerprint defense
    details: 50+ vector browser fingerprint disguise, hosts-rule ad blocking with 20 built-in lists, AES-256-GCM resource encryption, and activation gating.
  - icon: 🌍
    title: 10 UI languages
    details: Chinese, English, Arabic (RTL), Portuguese, Spanish, French, German, Russian, Japanese, and Korean — switch anytime in Settings.
---

<div class="wt-home">

## Stats at a glance

<div class="wt-stats">
  <div class="wt-stat"><div class="wt-stat-num">12</div><div class="wt-stat-label">App types</div></div>
  <div class="wt-stat"><div class="wt-stat-num">5</div><div class="wt-stat-label">On-device runtimes</div></div>
  <div class="wt-stat"><div class="wt-stat-num">10</div><div class="wt-stat-label">UI languages</div></div>
  <div class="wt-stat"><div class="wt-stat-num">50+</div><div class="wt-stat-label">Fingerprint vectors</div></div>
  <div class="wt-stat"><div class="wt-stat-num">3</div><div class="wt-stat-label">Signing schemes</div></div>
  <div class="wt-stat"><div class="wt-stat-num">20+</div><div class="wt-stat-label">Ad-block lists</div></div>
</div>

## What you can build

<div class="wt-matrix">
  <a class="wt-cell" href="/guide/app-types/web"><span class="wt-cell-icon">🌐</span><span class="wt-cell-title">Web</span><span class="wt-cell-desc">Wrap any URL in a fast WebView shell</span></a>
  <a class="wt-cell" href="/guide/app-types/multi-web"><span class="wt-cell-icon">🗂️</span><span class="wt-cell-title">Multi-Web</span><span class="wt-cell-desc">Tabbed browser, many sites as one app</span></a>
  <a class="wt-cell" href="/guide/app-types/html"><span class="wt-cell-icon">📄</span><span class="wt-cell-title">HTML</span><span class="wt-cell-desc">Package local HTML files as a standalone app</span></a>
  <a class="wt-cell" href="/guide/app-types/offline-pack"><span class="wt-cell-icon">🗃️</span><span class="wt-cell-title">Offline Pack</span><span class="wt-cell-desc">Bundle full offline web content</span></a>
  <a class="wt-cell" href="/guide/app-types/frontend"><span class="wt-cell-icon">⚛️</span><span class="wt-cell-title">Frontend</span><span class="wt-cell-desc">Ship an SPA dist folder as an app</span></a>
  <a class="wt-cell" href="/guide/app-types/wordpress"><span class="wt-cell-icon">🔗</span><span class="wt-cell-title">WordPress</span><span class="wt-cell-desc">Run WordPress over SQLite on-device</span></a>
  <a class="wt-cell" href="/guide/app-types/nodejs"><span class="wt-cell-icon">🟢</span><span class="wt-cell-title">Node.js</span><span class="wt-cell-desc">Embed a Node.js server runtime</span></a>
  <a class="wt-cell" href="/guide/app-types/php"><span class="wt-cell-icon">🐘</span><span class="wt-cell-title">PHP</span><span class="wt-cell-desc">Embed PHP 8.4 with Composer</span></a>
  <a class="wt-cell" href="/guide/app-types/python"><span class="wt-cell-icon">🐍</span><span class="wt-cell-title">Python</span><span class="wt-cell-desc">Embed a Python 3.14 server</span></a>
  <a class="wt-cell" href="/guide/app-types/go"><span class="wt-cell-icon">🐹</span><span class="wt-cell-title">Go</span><span class="wt-cell-desc">Embed a compiled Go server</span></a>
  <a class="wt-cell" href="/guide/app-types/media"><span class="wt-cell-icon">🎬</span><span class="wt-cell-title">Image &amp; Video</span><span class="wt-cell-desc">Turn media into a media player app</span></a>
  <a class="wt-cell" href="/guide/app-types/gallery"><span class="wt-cell-icon">🖼️</span><span class="wt-cell-title">Gallery</span><span class="wt-cell-desc">Build an image gallery app</span></a>
</div>

## Get started in 3 steps

<div class="wt-steps">
  <div class="wt-step"><div class="wt-step-num">1</div><div class="wt-step-title">Install WebToApp</div><div class="wt-step-desc">Download the latest APK from GitHub Releases and install it on your Android device (7.0+).</div><a class="wt-step-link" href="https://github.com/shiaho777/web-to-app/releases">Get the APK →</a></div>
  <div class="wt-step"><div class="wt-step-num">2</div><div class="wt-step-title">Create an app</div><div class="wt-step-desc">Tap the + button and pick a type — URL, HTML, Node.js, WordPress, or any of the 12 targets.</div><a class="wt-step-link" href="/guide/getting-started">Quick start guide →</a></div>
  <div class="wt-step"><div class="wt-step-num">3</div><div class="wt-step-title">Build &amp; share</div><div class="wt-step-desc">Tune the config, then export a signed APK or a Google Play-ready AAB — right on your phone.</div><a class="wt-step-link" href="/guide/app-actions/build-apk">How APK build works →</a></div>
</div>

<div class="wt-cta">
  <div class="wt-cta-inner">
    <div class="wt-cta-title">Start building on your phone today</div>
    <div class="wt-cta-desc">Open source · Unlicense · No PC, no cloud build queue</div>
    <div class="wt-cta-actions">
      <a class="wt-btn wt-btn-primary" href="https://github.com/shiaho777/web-to-app">Star &amp; download on GitHub</a>
      <a class="wt-btn wt-btn-ghost" href="/guide/">Read the docs</a>
    </div>
  </div>
</div>

</div>
