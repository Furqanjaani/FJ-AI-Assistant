package com.fj.assistant.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fj.assistant.core.AIEngine
import com.fj.assistant.core.MemorySystem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

data class ChatMessage(
    val id: String = System.currentTimeMillis().toString(),
    val text: String,
    val isUser: Boolean,
    val timestamp: Long = System.currentTimeMillis()
)

data class AppState(
    val messages: List<ChatMessage> = emptyList(),
    val isLoading: Boolean = false,
    val aiMode: String = "OFFLINE",
    val language: String = "Urdu+English",
    val userName: String = "Friend",
    val emotionEngineEnabled: Boolean = true,
    val securityEnabled: Boolean = true
)

class MainViewModel : ViewModel() {
    private val aiEngine = AIEngine()
    private val _state = MutableStateFlow(AppState())
    val state: StateFlow<AppState> = _state

    fun sendMessage(userInput: String) {
        if (userInput.isBlank()) return
        
        _state.value = _state.value.copy(
            messages = _state.value.messages + ChatMessage(
                text = userInput,
                isUser = true
            ),
            isLoading = true
        )
        
        viewModelScope.launch {
            try {
                val response = aiEngine.processInput(userInput, _state.value.aiMode)
                _state.value = _state.value.copy(
                    messages = _state.value.messages + ChatMessage(
                        text = response,
                        isUser = false
                    ),
                    isLoading = false
                )
            } catch (e: Exception) {
                Timber.e(e, "Error processing message")
                _state.value = _state.value.copy(
                    messages = _state.value.messages + ChatMessage(
                        text = "Kuch error hua. Please try again.",
                        isUser = false
                    ),
                    isLoading = false
                )
            }
        }
    }
    
    fun setAIMode(mode: String) {
        _state.value = _state.value.copy(aiMode = mode)
        Timber.d("AI Mode set to: $mode")
    }
    
    fun setLanguage(language: String) {
        _state.value = _state.value.copy(language = language)
    }
    
    fun setUserName(name: String) {
        _state.value = _state.value.copy(userName = name)
    }
    
    fun toggleEmotionEngine(enabled: Boolean) {
        _state.value = _state.value.copy(emotionEngineEnabled = enabled)
    }
    
    fun toggleSecurity(enabled: Boolean) {
        _state.value = _state.value.copy(securityEnabled = enabled)
    }
    
    fun clearMessages() {
        _state.value = _state.value.copy(messages = emptyList())
    }
}
