package com.fj.assistant.core

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import timber.log.Timber

class MemorySystem(context: Context) {
    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val encryptedPrefs: SharedPreferences = EncryptedSharedPreferences.create(
        context,
        "fj_memory_encrypted",
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun storeValue(key: String, value: String) {
        try {
            encryptedPrefs.edit().putString(key, value).apply()
            Timber.d("Stored: $key")
        } catch (e: Exception) {
            Timber.e(e, "Error storing value")
        }
    }

    fun getValue(key: String, default: String = ""): String {
        return try {
            encryptedPrefs.getString(key, default) ?: default
        } catch (e: Exception) {
            Timber.e(e, "Error retrieving value")
            default
        }
    }
}
