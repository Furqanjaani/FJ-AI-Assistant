# FJ AI Assistant - Tecno BG6 Installation Guide (Urdu + English)

## تیکو BG6 کے لیے مکمل انسٹالیشن گائیڈ

---

## مرحلہ 1: ونڈوز پر سیٹ اپ

### Java Install کریں
```
1. https://www.oracle.com/java/technologies/downloads/#java17 سے JDK 17 ڈاؤن لوڈ کریں
2. انسٹل کریں
3. Command Prompt میں چیک کریں:
   java -version
```

### Android Studio انسٹل کریں
```
1. https://developer.android.com/studio سے ڈاؤن لوڈ کریں
2. انسٹل کریں
3. Android SDK components ڈاؤن لوڈ کریں (پہلا لاچ)
```

### FJ Repository کلون کریں
```
Command Prompt میں:
git clone https://github.com/Furqanjaani/FJ-AI-Assistant.git
cd FJ-AI-Assistant\android
```

---

## مرحلہ 2: APK بنائیں

### Android Studio میں:
```
1. File > Open > FJ-AI-Assistant\android منتخب کریں
2. Gradle sync مکمل ہونے کا انتظار کریں (10 منٹ)
3. Build > Build APK(s) کریں
4. انتظار کریں (5 منٹ)
```

### یا Command Prompt میں:
```
cd C:\Users\YourUsername\Documents\FJ-AI-Assistant\android
.\gradlew.bat assembleDebug
```

APK یہاں ملے گا:
```
app\build\outputs\apk\debug\app-debug.apk
```

---

## مرحلہ 3: تیکو فون کو تیار کریں

### Developer Options چالو کریں:
```
1. Settings > About Phone
2. Build Number پر 7 بار ٹیپ کریں
3. Settings > Developer Options میں جائیں
4. USB Debugging ON کریں
5. Install via USB ON کریں
```

### USB سے فون کو جوڑیں:
```
1. اصل USB کیبل استعمال کریں
2. "Allow USB debugging" پر ہاں کریں
3. Command Prompt میں چیک کریں:
   adb devices
```

---

## مرحلہ 4: APK انسٹل کریں

### Method 1: Android Studio سے (آسان)
```
1. فون متصل ہے
2. Run button (سبز play icon) دبائیں
3. اپنا تیکو فون منتخب کریں
4. OK کریں
5. انتظار کریں - ایپ کھل جائے گی
```

### Method 2: Command Prompt سے
```
cd C:\Users\YourUsername\Documents\FJ-AI-Assistant\android
adb install -r app\build\outputs\apk\debug\app-debug.apk
```

### Method 3: دستی انسٹالیشن
```
1. APK فون میں کاپی کریں
2. File Manager سے کھولیں
3. Install ٹیپ کریں
```

---

## مرحلہ 5: اجازتیں دیں

فون پر یہ اجازتیں دیں:
```
✅ Microphone (آواز کے لیے)
✅ Camera (کیمرا کے لیے)
✅ Location (ٹریکنگ کے لیے)
✅ Contacts (رابطوں کے لیے)
✅ Storage (ڈیٹا کے لیے)
```

---

## مرحلہ 6: ایپ سیٹ اپ کریں

```
1. FJ ایپ کھولیں
2. Settings ٹیپ کریں
3. منتخب کریں:
   - AI Mode: OFFLINE
   - Language: Urdu+English
   - Features: Enable
4. Chat ٹیپ کریں
```

---

## مرحلہ 7: ٹیسٹ کریں

### کچھ کہیں:
```
"سلام" → "وعليكم السلام"
"ہیلو" → "Hello! How are you?"
"وقت کیا ہے" → موجودہ وقت
```

---

## مسائل حل کریں

### اگر `adb devices` خالی دکھائے:
```
1. مختلف USB کیبل استعمال کریں
2. مختلف USB پورٹ آزمائیں
3. فون سے Allow کریں
4. ADB دوبارہ شروع کریں:
   adb kill-server
   adb start-server
```

### اگر انسٹالیشن ناکام ہو:
```
adb uninstall com.fj.assistant
adb install -r app\build\outputs\apk\debug\app-debug.apk
```

### اگر ایپ کریش ہو:
```
1. Settings > Apps > FJ > Clear Data
2. دوبارہ کھولیں
3. تمام اجازتیں دیں
```

---

## کامیاب! 🎉

آپ کے پاس اب اپنا ذاتی AI اسسٹنٹ ہے!

- ✅ آف لائن چیٹ
- ✅ آواز کنٹرول (اردو + انگریزی)
- ✅ جذبات کی شناخت
- ✅ سیٹنگز
- ✅ سیکیورٹی

**خوش رہیں اور استعمال کریں! 🚀**

---

## Exact Steps for Tecno BG6 (Urdu/English)

### Windows Computer مماڑی (Single Commands)

```bash
# 1. Java Check
java -version

# 2. Go to project
cd C:\Users\YourUsername\Documents\FJ-AI-Assistant\android

# 3. Build APK
.\gradlew.bat assembleDebug

# 4. Check device
adb devices

# 5. Install on phone
adb install -r app\build\outputs\apk\debug\app-debug.apk

# 6. Check if app working
adb logcat | find "FJ"
```

### فون کے مراحل (Tecno BG6)

```
1. Settings > About Phone > Build Number (7 taps)
2. Settings > Developer Options
   ✅ USB Debugging ON
   ✅ Install via USB ON
3. PC سے USB لگائیں
4. "Allow" ٹیپ کریں
5. ایپ کھول جائے گی
6. Settings میں جائیں
7. Language: Urdu+English
8. AI Mode: OFFLINE
9. Chat کریں
```

---

## Quick Reference Card

| مسئلہ | حل |
|------|----|
| Java نہیں ملا | JDK 17 دوبارہ انسٹل کریں |
| Device نہیں دیکھ رہے | USB debugging allow کریں |
| APK انسٹل نہیں ہو رہا | `adb uninstall com.fj.assistant` کریں |
| ایپ کریش ہو | Clear Data > دوبارہ انسٹل |
| آواز کام نہیں | Microphone permission دیں |

---

**Ready? Start building! 🚀**
