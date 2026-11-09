# TV Link Companion

> **Lightweight Android TV Shortcut Bridge for TV Link Remote**

**TV Link Companion** is an open-source TV helper application designed to work seamlessly with **TV Link** and **TV Link Smart** mobile controllers. It acts as an instant intent bridge, allowing you to launch installed, system, and sideloaded TV apps directly from your phone remote.

---

## ✨ Features

* ⚡ **Instant Launch:** Zero-latency switching to your favorite TV apps.
* 🔋 **Zero Battery & RAM Draw:** Runs exclusively for ~200ms during an app launch, then terminates immediately. No background services, no persistent wakelocks, and no broadcast listeners.
* 🔒 **100% Private & Open Source:** No network requests, telemetry, ads, or data collection.
* 📺 **Leanback & Sideloaded Support:** Works with both native Android TV Leanback apps and sideloaded applications.

---

## 📥 Installation

Grab the latest build from the **[Releases](https://github.com/unicsam/tvlink-companion/releases)** page.

### Method 1: Downloader App (Fastest on TV)
1. Install **Downloader by AFTVnews** from the Google Play Store on your TV.
2. Enter the direct link to the latest APK from the **Releases** tab.
3. Install and open the app once to verify setup.

### Method 2: Send Files to TV
1. Download the APK file on your mobile device.
2. Use **Send Files to TV** to transfer it wirelessly to your television.
3. Open using a file manager on your TV to install.

### Method 3: ADB (For Developers)
```bash
adb install -r tvlink-companion-v1.0.apk
```

---

## 🛠️ Verification

1. Launch **TV Link Companion** from your TV app drawer.
2. Confirm the screen displays:
   ```
   COMPANION ACTIVE & READY
   ```
3. Click **Return to TV Home**. No background configuration is needed.

---

## 🏗️ Building from Source

Prerequisites: Android SDK with API 34.

```bash
# Clone the repository
git clone https://github.com/unicsam/tvlink-companion.git
cd tvlink-companion

# Build debug APK
./gradlew assembleDebug

# Build unsigned release APK
./gradlew assembleRelease
```

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
