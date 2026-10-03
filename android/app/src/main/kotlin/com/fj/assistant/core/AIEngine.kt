package com.fj.assistant.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class AIEngine {
    private val languageProcessor = LanguageProcessor()
    private val contextManager = ContextManager()
    private val emotionAnalyzer = EmotionAnalyzer()

    suspend fun processInput(userInput: String, aiMode: String): String = withContext(Dispatchers.Default) {
        try {
            Timber.d("Processing: $userInput (Mode: $aiMode)")
            
            // 1. Detect emotion
            val emotion = emotionAnalyzer.detectEmotion(userInput)
            Timber.d("Emotion: $emotion")
            
            // 2. Detect language
            val language = languageProcessor.detectLanguage(userInput)
            Timber.d("Language: $language")
            
            // 3. Generate response based on mode
            val response = when (aiMode) {
                "OFFLINE" -> generateOfflineResponse(userInput, emotion, language)
                "ONLINE" -> generateOnlineResponse(userInput, emotion, language)
                "HYBRID" -> generateHybridResponse(userInput, emotion, language)
                else -> generateOfflineResponse(userInput, emotion, language)
            }
            
            // 4. Store interaction
            contextManager.storeInteraction(userInput, response)
            
            response
        } catch (e: Exception) {
            Timber.e(e, "Error processing input")
            "Maafi kijiye, kuch masla hua. Dobara koshish karein."
        }
    }

    private fun generateOfflineResponse(input: String, emotion: String, language: String): String {
        return when {
            input.contains("salam", ignoreCase = true) || 
            input.contains("السلام") -> "Wa alaikum assalam! Aap kaise ho?"
            
            input.contains("hello", ignoreCase = true) || 
            input.contains("hi", ignoreCase = true) -> "Hello! Kaisa lagta hoon main?"
            
            input.contains("kya haal", ignoreCase = true) -> "Main bilkul theek hoon, shukriya poochne ke liye!"
            
            input.contains("lights", ignoreCase = true) -> "Lights on kar diye!"
            
            input.contains("time", ignoreCase = true) -> "Aab ka samay: " + java.time.LocalTime.now().toString()
            
            emotion == "HAPPY" -> "Bilkul! Aapka khusi mere liye kaafi hai! \ud83d\ude0a"
            
            emotion == "SAD" -> "Mujhe aapki khusi ki fikr hai. Kya main kuch madad kar sakta hoon? \ud83d\ude25"
            
            else -> "Bahut shandar sawal! \"$input\" ke baare mein zyada jaankari chahiye?"
        }
    }

    private fun generateOnlineResponse(input: String, emotion: String, language: String): String {
        // Would call OpenAI/Gemini API
        return "[Online Mode] Aapka message: $input"
    }

    private fun generateHybridResponse(input: String, emotion: String, language: String): String {
        // Try online first, fallback to offline
        return generateOfflineResponse(input, emotion, language)
    }
}

class LanguageProcessor {
    fun detectLanguage(text: String): String {
        return when {
            text.contains(Regex("[\u0600-\u06FF]")) -> "Urdu"
            else -> "English"
        }
    }
}

class EmotionAnalyzer {
    fun detectEmotion(text: String): String {
        return when {
            text.contains(Regex("khush|happy|excited|\ud83d\ude0a", RegexOption.IGNORE_CASE)) -> "HAPPY"
            text.contains(Regex("udas|sad|depressed|\ud83d\ude25", RegexOption.IGNORE_CASE)) -> "SAD"
            text.contains(Regex("gussa|angry|mad|\ud83d\ude21", RegexOption.IGNORE_CASE)) -> "ANGRY"
            text.contains(Regex("confusion|confused|\ud83d\ude15", RegexOption.IGNORE_CASE)) -> "CONFUSED"
            else -> "NEUTRAL"
        }
    }
}

class ContextManager {
    private val conversationHistory = mutableListOf<Pair<String, String>>()
    
    fun storeInteraction(input: String, response: String) {
        conversationHistory.add(input to response)
    }
    
    fun getContext(): List<Pair<String, String>> = conversationHistory
    
    fun clearHistory() {
        conversationHistory.clear()
    }
}
