---
layout: home

hero:
  name: WebToApp
  text: 在手机上构建 Android APK
  tagline: 一个远超"网址转 App"的设备端 APK 工坊 —— fork+exec 真实服务运行时、搭载加固的反审查网络栈、导出 Play 级安装包,全程无需电脑,也无需云端构建队列。
  image:
    src: /logo.png
    alt: WebToApp
  actions:
    - theme: brand
      text: 快速开始
      link: /zh/guide/introduction
    - theme: alt
      text: 下载 APK
      link: https://github.com/shiaho777/web-to-app/releases
    - theme: alt
      text: 开发者文档
      link: /zh/developer/

features:
  - icon: ⚙️
    title: 真实的设备端运行时
    details: Node.js、PHP、Python、Go、WordPress 作为原生二进制直接从应用存储 fork+exec —— 如同 Termux,但打包成可安装的 APK。
  - icon: 🛡️
    title: 加固网络栈
    details: DNS-over-HTTPS、带本地 MITM 桥的 TLS 指纹伪造、加密客户端 Hello(ECH)、按应用代理,以及针对受限 SPA 的 CORS 绕过。
  - icon: 📦
    title: 自包含构建
    details: 二进制 AXML/ARSC 打补丁、权限裁剪、V1/V2/V3 签名、Google Play 级 AAB 导出 —— 全部通过 apksig 在应用内完成。
  - icon: 🧩
    title: 发布后仍可扩展
    details: 添加 JS/CSS 模块、Tampermonkey 风格油猴脚本,或 MV3 Chrome 扩展(从 Chrome 网上应用店实时搜索),无需重建宿主。
  - icon: 🔒
    title: 隐私与指纹防护
    details: 50+ 维浏览器指纹伪装、内置 20 个过滤列表的 hosts 去广告、AES-256-GCM 资源加密,以及激活码门控。
  - icon: 🌍
    title: 10 种界面语言
    details: 中文、英文、阿拉伯文(RTL)、葡萄牙文、西班牙文、法文、德文、俄文、日文、韩文 —— 在设置中随时切换。
---

<div class="wt-home">

## 数字一览

<div class="wt-stats">
  <div class="wt-stat"><div class="wt-stat-num">12</div><div class="wt-stat-label">种应用类型</div></div>
  <div class="wt-stat"><div class="wt-stat-num">5</div><div class="wt-stat-label">个设备端运行时</div></div>
  <div class="wt-stat"><div class="wt-stat-num">10</div><div class="wt-stat-label">种界面语言</div></div>
  <div class="wt-stat"><div class="wt-stat-num">50+</div><div class="wt-stat-label">维指纹伪装</div></div>
  <div class="wt-stat"><div class="wt-stat-num">3</div><div class="wt-stat-label">种签名方案</div></div>
  <div class="wt-stat"><div class="wt-stat-num">20+</div><div class="wt-stat-label">个广告过滤列表</div></div>
</div>

## 能构建什么

<div class="wt-matrix">
  <a class="wt-cell" href="/zh/guide/app-types/web"><span class="wt-cell-icon">🌐</span><span class="wt-cell-title">网页</span><span class="wt-cell-desc">把任意网址封装成流畅的 WebView 应用</span></a>
  <a class="wt-cell" href="/zh/guide/app-types/multi-web"><span class="wt-cell-icon">🗂️</span><span class="wt-cell-title">多站点</span><span class="wt-cell-desc">标签页浏览器,多个站点合成一个应用</span></a>
  <a class="wt-cell" href="/zh/guide/app-types/html"><span class="wt-cell-icon">📄</span><span class="wt-cell-title">HTML</span><span class="wt-cell-desc">把本地 HTML 文件打包成独立应用</span></a>
  <a class="wt-cell" href="/zh/guide/app-types/offline-pack"><span class="wt-cell-icon">🗃️</span><span class="wt-cell-title">离线包</span><span class="wt-cell-desc">打包完整的离线网页内容</span></a>
  <a class="wt-cell" href="/zh/guide/app-types/frontend"><span class="wt-cell-icon">⚛️</span><span class="wt-cell-title">前端工程</span><span class="wt-cell-desc">把 SPA 构建产物作为应用发布</span></a>
  <a class="wt-cell" href="/zh/guide/app-types/wordpress"><span class="wt-cell-icon">🔗</span><span class="wt-cell-title">WordPress</span><span class="wt-cell-desc">在设备端基于 SQLite 运行 WordPress</span></a>
  <a class="wt-cell" href="/zh/guide/app-types/nodejs"><span class="wt-cell-icon">🟢</span><span class="wt-cell-title">Node.js</span><span class="wt-cell-desc">内置 Node.js 服务端运行时</span></a>
  <a class="wt-cell" href="/zh/guide/app-types/php"><span class="wt-cell-icon">🐘</span><span class="wt-cell-title">PHP</span><span class="wt-cell-desc">内置 PHP 8.4 与 Composer</span></a>
  <a class="wt-cell" href="/zh/guide/app-types/python"><span class="wt-cell-icon">🐍</span><span class="wt-cell-title">Python</span><span class="wt-cell-desc">内置 Python 3.14 服务端</span></a>
  <a class="wt-cell" href="/zh/guide/app-types/go"><span class="wt-cell-icon">🐹</span><span class="wt-cell-title">Go</span><span class="wt-cell-desc">内置编译好的 Go 服务端</span></a>
  <a class="wt-cell" href="/zh/guide/app-types/media"><span class="wt-cell-icon">🎬</span><span class="wt-cell-title">图片与视频</span><span class="wt-cell-desc">把媒体内容变成播放器应用</span></a>
  <a class="wt-cell" href="/zh/guide/app-types/gallery"><span class="wt-cell-icon">🖼️</span><span class="wt-cell-title">画廊</span><span class="wt-cell-desc">构建图片画廊应用</span></a>
</div>

## 三步快速开始

<div class="wt-steps">
  <div class="wt-step"><div class="wt-step-num">1</div><div class="wt-step-title">安装 WebToApp</div><div class="wt-step-desc">从 GitHub Releases 下载最新 APK,安装到 Android 7.0+ 设备上。</div><a class="wt-step-link" href="https://github.com/shiaho777/web-to-app/releases">获取 APK →</a></div>
  <div class="wt-step"><div class="wt-step-num">2</div><div class="wt-step-title">创建应用</div><div class="wt-step-desc">点击 + 选择类型 —— 网址、HTML、Node.js、WordPress,或 12 种目标中的任意一种。</div><a class="wt-step-link" href="/zh/guide/getting-started">查看快速开始 →</a></div>
  <div class="wt-step"><div class="wt-step-num">3</div><div class="wt-step-title">构建并分享</div><div class="wt-step-desc">调整配置后,直接在手机上导出签名 APK 或 Google Play 级 AAB。</div><a class="wt-step-link" href="/zh/guide/app-actions/build-apk">了解 APK 构建 →</a></div>
</div>

<div class="wt-cta">
  <div class="wt-cta-inner">
    <div class="wt-cta-title">现在就在手机上开始构建</div>
    <div class="wt-cta-desc">开源 · Unlicense 协议 · 无需电脑,无需云端构建队列</div>
    <div class="wt-cta-actions">
      <a class="wt-btn wt-btn-primary" href="https://github.com/shiaho777/web-to-app">在 GitHub 上标星并下载</a>
      <a class="wt-btn wt-btn-ghost" href="/zh/guide/">阅读文档</a>
    </div>
  </div>
</div>

</div>
