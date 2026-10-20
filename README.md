# SHADOW STRIKE: SURVIVAL
**3D Native Android Tactical Action Game**

## Overview
- **Target Platform**: Android (Min SDK 24 / Android 7.0+, Target SDK 34 / Android 14)
- **Language**: Kotlin 2.0
- **UI Framework**: Jetpack Compose (Material3)
- **3D Engine**: OpenGL ES 3.0 Native SurfaceView Renderer
- **Orientation**: Fixed Fullscreen Landscape

---

## 3 Quick Ways to Build and Install on Your Phone:

### Route 1: Instant Cloud Build (No Android Studio required!)
1. Create a GitHub repository and upload this project folder.
2. Go to the **Actions** tab on GitHub.
3. The workflow **"Build Shadow Strike Android APK"** will automatically compile the code on GitHub's cloud servers.
4. Download the generated **`ShadowStrike-Survival-Debug-APK`** artifact from the summary page.
5. Transfer the `app-debug.apk` to your phone and tap to install!

### Route 2: Build Locally with Android Studio
1. Open **Android Studio** (Hedgehog, Iguana, or Koala).
2. Select **File > Open** and choose this extracted project folder.
3. Allow Gradle to sync dependencies.
4. Connect your Android phone with **USB Debugging** enabled (Developer Options).
5. Click the green **Run (▶)** button. Android Studio will build and install the APK directly onto your phone!

### Route 3: Build via Terminal Command Line
```bash
# Build the debug APK
./gradlew assembleDebug

# Install directly to connected phone via ADB
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

---

## Game Architecture Components
- `MainActivity.kt`: Fullscreen landscape activity lifecycle management.
- `MainMenuScreen.kt`: Jetpack Compose tactical menu & mission selection.
- `GameScreen.kt`: In-game HUD overlay and multi-touch virtual joysticks.
- `GameRenderer.kt`: Hardware-accelerated OpenGL ES 3.0 renderer.
- `PlayerController.kt`: Movement, camera yaw/pitch, and health state.
- `SettingsRepository.kt`: SharedPreferences local storage for graphics & audio preferences.
