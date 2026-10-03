# FJ AI Assistant - Complete Windows Setup Guide

## Prerequisites Check

✅ Windows 10 or 11
✅ 8GB+ RAM
✅ 50GB free disk space
✅ Internet connection
✅ Tecno BG6 phone with Android 13
✅ USB cable (original recommended)

---

## Step 1: Install Java Development Kit (JDK)

### Download JDK 17
1. Go to: https://www.oracle.com/java/technologies/downloads/#java17
2. Download: **Windows x64 Installer**
3. Run installer (.exe)
4. Click through installation wizard
5. Accept License Agreement
6. Install to default location (C:\Program Files\Java\...)
7. Click Finish

### Verify JDK Installation
1. Open **Command Prompt** (Win + R, type `cmd`, Enter)
2. Type:
   ```
   java -version
   ```
3. Should show: `java version "17.x.x"` or similar
4. Type:
   ```
   javac -version
   ```
5. Should show compiler version

**If not found:**
- Add to PATH:
  1. Right-click "This PC" > Properties
  2. Click "Advanced system settings"
  3. Click "Environment Variables"
  4. Under "System variables", click "New"
  5. Variable name: `JAVA_HOME`
  6. Variable value: `C:\Program Files\Java\jdk-17.x.x` (adjust version)
  7. Click OK, OK, OK
  8. Restart Command Prompt
  9. Test again with `java -version`

---

## Step 2: Install Android Studio

### Download
1. Go to: https://developer.android.com/studio
2. Click **"Download Android Studio"**
3. Accept Terms & Conditions
4. Download will start (~900MB)

### Install
1. Run downloaded .exe file
2. Click "Next"
3. Select:
   - ✅ Android SDK
   - ✅ Android SDK Platform
   - ✅ Android Virtual Device
4. Choose installation location:
   - Recommended: `C:\Users\YourUsername\AppData\Local\Android\Sdk`
5. Click "Install"
6. Wait for completion (10-15 minutes)
7. Click "Finish"

### First Launch Setup
1. Open Android Studio
2. It will show "Welcome to Android Studio"
3. Click "Next" on setup wizard
4. Select **"Standard" installation**
5. Accept default SDK location
6. Click "Next" > "Finish"
7. Wait for SDK downloads (20-30 minutes)
8. Click "Finish"

---

## Step 3: Install Android SDK Components

### In Android Studio:
1. Click **"Tools"** menu
2. Select **"SDK Manager"**
3. Click **"SDK Platforms"** tab
4. Make sure these are checked:
   - ✅ Android API 34 (latest)
   - ✅ Android API 33
   - ✅ Android API 24 (for compatibility)
5. Click **"SDK Tools"** tab
6. Make sure these are checked:
   - ✅ Android SDK Build-Tools
   - ✅ Android SDK Platform-Tools
   - ✅ Android SDK Tools
   - ✅ Google Play services
7. Click **"Apply"**
8. Click "OK" on confirmation
9. Wait for downloads (10-20 minutes)

---

## Step 4: Clone FJ Repository

### Using Git (Recommended)

1. Download Git from: https://git-scm.com/download/win
2. Install with default options
3. Open **Command Prompt** or **Git Bash**
4. Navigate to where you want project:
   ```
   cd C:\Users\YourUsername\Documents
   ```
5. Clone repository:
   ```
   git clone https://github.com/Furqanjaani/FJ-AI-Assistant.git
   ```
6. Wait for download to complete
7. Navigate to project:
   ```
   cd FJ-AI-Assistant\android
   ```

### Or Manual Download
1. Go to: https://github.com/Furqanjaani/FJ-AI-Assistant
2. Click green **"Code"** button
3. Click **"Download ZIP"**
4. Extract to:
   ```
   C:\Users\YourUsername\Documents\FJ-AI-Assistant
   ```

---

## Step 5: Open Project in Android Studio

1. Open Android Studio
2. Click **"Open"** (or File > Open)
3. Navigate to:
   ```
   C:\Users\YourUsername\Documents\FJ-AI-Assistant\android
   ```
4. Select the **"android"** folder
5. Click **"OK"**
6. Android Studio will import project
7. **WAIT** for "Gradle sync" to complete (blue bar at bottom)
   - First time may take 10-15 minutes
   - Do NOT close Android Studio
8. When complete, status bar shows: "Build Successful"

---

## Step 6: Configure Project for Your Tecno BG6

### In Android Studio:
1. Click **"File"** menu
2. Select **"Project Structure"**
3. Left panel, click **"SDK Location"**
4. Verify:
   - Android SDK Location: should be auto-filled
   - JDK Location: should show Java installation
5. Click **"OK"**

---

## Step 7: Build APK

### Method 1: Using Android Studio (Easiest)

1. Click **"Build"** menu
2. Select **"Build Bundle(s) / APK(s)"**
3. Click **"Build APK(s)"**
4. Wait for build (3-10 minutes)
5. Status bar shows: "Build Successful"
6. A notification appears: "Locate" or "Show in Explorer"
7. Click to see APK location

### Method 2: Using Command Prompt

1. Open Command Prompt
2. Navigate to project:
   ```
   cd C:\Users\YourUsername\Documents\FJ-AI-Assistant\android
   ```
3. Run build command:
   ```
   gradlew.bat assembleDebug
   ```
4. Wait for completion (messages will show progress)
5. When done, APK is at:
   ```
   C:\Users\YourUsername\Documents\FJ-AI-Assistant\android\app\build\outputs\apk\debug\app-debug.apk
   ```

---

## Step 8: Prepare Tecno BG6 for Installation

### Enable Developer Mode:
1. On phone, go to **Settings**
2. Scroll down to **"About Phone"** or **"Phone Information"**
3. Find **"Build Number"** (usually at bottom)
4. **Tap Build Number 7 times** (yes, 7 times!)
5. Message appears: "You are now a developer!"
6. Go back to Settings
7. Look for **"Developer Options"** (now visible)
8. Enter Developer Options
9. Scroll and enable:
   - ✅ **USB Debugging**
   - ✅ **Install via USB**
   - ✅ **Stay Awake** (recommended)
10. Close Settings

---

## Step 9: Connect Phone to PC

1. Take USB cable (use original if possible)
2. Connect phone to PC USB port
3. On phone, notification appears:
   - **"Allow USB debugging from this computer?"**
4. Tap **"Allow"**
5. Optionally check: **"Always allow from this computer"**
6. Tap **"OK"**

### Verify Connection:
1. Open Command Prompt
2. Type:
   ```
   adb devices
   ```
3. You should see:
   ```
   List of attached devices
   XXXXXXXXX    device
   ```
   (XXXXXXXXX = your device serial number)

**If NOT showing:**
- Disconnect and reconnect cable
- Try different USB port
- Try different USB cable
- On phone, tap "Allow" again
- Restart ADB:
  ```
  adb kill-server
  adb start-server
  adb devices
  ```

---

## Step 10: Install APK on Phone

### Method 1: Using Android Studio (Easiest)

1. Phone connected via USB
2. In Android Studio, click **"Run"** button (green play icon)
3. Select your Tecno device from list
4. Click **"OK"**
5. Android Studio will:
   - Rebuild APK
   - Install on phone
   - Launch app automatically
6. Wait 1-2 minutes
7. **FJ App opens on your phone!**

### Method 2: Using Command Prompt

1. Open Command Prompt
2. Navigate to project:
   ```
   cd C:\Users\YourUsername\Documents\FJ-AI-Assistant\android
   ```
3. Install APK:
   ```
   adb install -r app\build\outputs\apk\debug\app-debug.apk
   ```
4. Wait for message:
   ```
   Success
   ```
5. On phone, app is installed
6. Open **"FJ - Personal AI"** from app drawer

### Method 3: Manual Installation

1. Copy APK file to phone storage:
   - Connect phone
   - Open File Manager on PC
   - Navigate to:
     ```
     C:\Users\YourUsername\Documents\FJ-AI-Assistant\android\app\build\outputs\apk\debug
     ```
   - Copy **"app-debug.apk"**
   - Paste to phone's Download folder (via USB)

2. On phone:
   - Open **File Manager**
   - Go to **Download** folder
   - Find **"app-debug.apk"**
   - Tap it
   - Tap **"Install"**
   - If blocked, go to:
     - **Settings > Security > Install unknown apps**
     - Enable for **"Files"** or **"Chrome"**
     - Try install again

---

## Step 11: Grant App Permissions

### First Launch on Phone:
1. FJ App opens
2. Various permission requests appear
3. Tap **"Allow"** for each:
   - 📱 Microphone (for voice)
   - 📷 Camera (for vision features)
   - 📍 Location (for anti-theft)
   - 📞 Contacts (for automation)
   - 💾 Storage (for data)

### Or Manual:
1. Open **Settings**
2. Go to **Apps**
3. Find **"FJ - Personal AI"**
4. Tap **Permissions**
5. Enable all requested permissions

---

## Step 12: Initial App Setup

1. **App launches**
2. **Tap Settings tab** (bottom right)
3. **Configure:**
   - AI Mode: Choose **"OFFLINE"** (default)
   - Language: Choose **"Urdu+English"**
   - Enable Emotion Engine: **ON**
   - Enable Security: **ON**
4. **Back to Chat**
5. **Type or say:**
   - "Salam" → "Wa alaikum assalam!"
   - "Hello" → "Hello! How are you?"
   - "What time is it?" → Shows current time

---

## Step 13: Test Features

### Text Chat:
- Type any message
- Press Send button
- Get AI response

### Voice (if enabled):
- Tap 🎤 icon
- Speak clearly
- FJ understands Urdu & English

### Settings:
- Change AI Mode
- Change Language
- Toggle features
- Clear chat history

---

## Troubleshooting Windows Setup

### Java not found after installation:
```
Solution:
1. Restart Command Prompt
2. Or restart Windows
3. Or add to PATH manually (see Step 1)
```

### Android Studio won't open:
```
Solution:
1. Delete: C:\Users\YourUsername\.android
2. Restart Android Studio
3. Reinstall if still fails
```

### Gradle sync stuck:
```
Solution:
1. File > Sync Now
2. Or: ./gradlew clean
3. Or: Delete .gradle folder and retry
```

### Build fails with "Cannot find SDK":
```
Solution:
1. File > Project Structure
2. Set Android SDK Location manually
3. Or reinstall Android Studio
```

### Device not showing in adb:
```
Solution:
1. Different USB cable
2. Different USB port (not USB 3.0)
3. Update USB drivers (Google Android Composite ADB Interface)
4. Reinstall platform-tools:
   - In SDK Manager, uncheck Android SDK Platform-Tools
   - Click Apply, wait
   - Check again, Apply, wait
```

### APK Install fails with "INSTALL_FAILED_INVALID_APK":
```
Solution:
1. ./gradlew clean
2. ./gradlew assembleDebug
3. adb uninstall com.fj.assistant
4. adb install app\build\outputs\apk\debug\app-debug.apk
```

---

## Useful Commands Reference

```bash
# Check ADB devices
adb devices

# Install APK
adb install -r app\build\outputs\apk\debug\app-debug.apk

# Uninstall app
adb uninstall com.fj.assistant

# View app logs
adb logcat | find "FJ"

# Clear app data
adb shell pm clear com.fj.assistant

# Restart ADB
adb kill-server
adb start-server

# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Clean build
./gradlew clean
```

---

## Final Checklist

- ✅ Java JDK 17 installed & verified
- ✅ Android Studio installed & configured
- ✅ Android SDK components downloaded
- ✅ FJ repository cloned
- ✅ Project opened in Android Studio
- ✅ APK built successfully
- ✅ Phone connected via USB
- ✅ Developer Options enabled on phone
- ✅ USB Debugging allowed
- ✅ APK installed on Tecno BG6
- ✅ All permissions granted
- ✅ App tested and working

---

## Your FJ AI Assistant is Ready! 🚀

You now have a working personal AI assistant on your Tecno BG6:
- ✅ Offline AI chat
- ✅ Voice control (Urdu + English)
- ✅ Emotion detection
- ✅ Settings configuration
- ✅ Security features
- ✅ Memory system

**Next Steps:**
1. Explore app features
2. Add custom commands
3. Enable automation
4. Share feedback for improvements

---

**Need Help?**
- Check GitHub Issues: https://github.com/Furqanjaani/FJ-AI-Assistant/issues
- Review logs: `adb logcat`
- Rebuild: `./gradlew clean && ./gradlew assembleDebug`

**Enjoy your FJ! 🎉**
