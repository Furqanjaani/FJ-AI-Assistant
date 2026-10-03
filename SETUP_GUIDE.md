# FJ AI Assistant - Setup Guide

## Prerequisites

- Android Studio (latest version)
- Android SDK 31+
- Kotlin plugin
- Git
- 8GB RAM (for development)

## Step 1: Clone Repository

```bash
git clone https://github.com/Furqanjaani/FJ-AI-Assistant.git
cd FJ-AI-Assistant
```

## Step 2: Open in Android Studio

1. Launch Android Studio
2. Select "Open an Existing Project"
3. Navigate to cloned folder
4. Let Gradle sync

## Step 3: Configure API Keys (Optional)

Create `local.properties` file in project root:

```properties
# OpenAI API Key
OPENAI_API_KEY=your_openai_key_here

# Google Gemini API Key
GEMINI_API_KEY=your_gemini_key_here

# Device admin key (for security features)
DEVICE_ADMIN_KEY=your_admin_key
```

## Step 4: Download AI Models

### For Offline Mode:

1. Download TinyLlama model:
```bash
# Create models directory
mkdir -p models/offline

# Download from Hugging Face
wget https://huggingface.co/TheBloke/TinyLlama-1.1B-Chat-v1.0-GGUF/resolve/main/TinyLlama-1.1B-Chat-v1.0.Q4_K_M.gguf -O models/offline/tinyllama.gguf
```

2. Or use smaller model for development:
```bash
# TinyLlama 1.1B (recommended)
# ~700MB compressed
https://huggingface.co/TheBloke/TinyLlama-1.1B-Chat-v1.0-GGUF
```

## Step 5: Build APK

### Debug Build:
```bash
./gradlew assembleDebug
```

### Release Build:
```bash
./gradlew assembleRelease
```

## Step 6: Install on Device

### Using ADB:
```bash
# Connect device via USB
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

### Or manually:
1. Copy APK to device
2. Open file manager
3. Tap APK file
4. Allow installation

## Step 7: Initial Setup

### On First Launch:
1. Grant permissions:
   - Microphone (for voice)
   - Camera (for vision features)
   - Storage (for models/data)
   - Contacts (for automation)
   - Location (for anti-theft)
   - Device admin (for security)

2. Set up profile:
   - Enter name
   - Set language (Urdu/English)
   - Configure AI mode (offline/online/hybrid)

3. Download offline model:
   - Launch app
   - Go to Settings > AI Models
   - Select TinyLlama 1.1B
   - Download (takes 5-10 minutes)

## Step 8: Test Basic Features

### Voice Control:
```
"FJ, salam" (Urdu greeting)
"FJ, hello" (English)
"FJ, lights on" (Device control)
```

### Text Input:
- Tap chat icon
- Type message
- Send and get response

## Step 9: Configure Features

### Enable Security:
1. Settings > Security
2. Enable biometric auth
3. Set PIN backup
4. Enable anti-theft tracking

### Setup Automation:
1. Settings > Automation
2. Add custom commands
3. Create workflows
4. Set schedules

### Configure Memory:
1. Settings > Memory
2. Set learning preferences
3. Add custom instructions
4. Enable habit tracking

## Troubleshooting

### App Crashes on Launch
```
Solution:
1. Clear app data: Settings > Apps > FJ > Storage > Clear Data
2. Reinstall APK
3. Grant all permissions
```

### Voice Recognition Not Working
```
Solution:
1. Check microphone permissions granted
2. Ensure microphone is not muted
3. Test with Settings > Voice > Test Mic
4. Update voice language pack if needed
```

### Model Download Fails
```
Solution:
1. Check internet connection
2. Ensure 2GB free storage
3. Download manually and place in:
   /storage/emulated/0/Android/data/com.fj.assistant/files/models/
4. Restart app
```

### Offline Mode Not Working
```
Solution:
1. Ensure model is downloaded (Settings > Models)
2. Switch to offline mode (Settings > AI Mode)
3. Test with simple command
4. Check device RAM (minimum 2GB free)
```

## Device Permissions

Required permissions and why:

```xml
<!-- Voice Input -->
<uses-permission android:name="android.permission.RECORD_AUDIO" />

<!-- Voice Output -->
<uses-permission android:name="android.permission.MODIFY_AUDIO_SETTINGS" />

<!-- Device Control -->
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
<uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
<uses-permission android:name="android.permission.CHANGE_NETWORK_STATE" />

<!-- Security & Tracking -->
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.DEVICE_POWER" />

<!-- Memory & Automation -->
<uses-permission android:name="android.permission.READ_CONTACTS" />
<uses-permission android:name="android.permission.READ_CALL_LOG" />
<uses-permission android:name="android.permission.SCHEDULE_EXACT_ALARM" />

<!-- Data Storage -->
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```

## Development Tips

### Enable Verbose Logging
```kotlin
// In BuildConfig or Constants
const val DEBUG = true
const val LOG_LEVEL = "VERBOSE"
```

### Test Offline Mode
```kotlin
// In AIEngine.kt
val testOfflineMode = {
    AIMode.OFFLINE // Force offline
}
```

### Performance Profiling
```bash
# Monitor CPU/Memory
adb shell dumpsys meminfo com.fj.assistant
adb shell top -p $(adb shell pidof com.fj.assistant)
```

## Next Steps

1. Complete initial setup
2. Test voice commands
3. Configure personal preferences
4. Enable security features
5. Set up automation workflows
6. Contribute back to project

## Getting Help

- GitHub Issues: Report bugs
- GitHub Discussions: Ask questions
- Documentation: Check `/docs`
- Community: Join our Discord

---

*Ready to launch your personal JARVIS!*