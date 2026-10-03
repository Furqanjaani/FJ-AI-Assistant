package com.fj.assistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fj.assistant.ui.screens.ChatScreen
import com.fj.assistant.ui.screens.SettingsScreen
import com.fj.assistant.ui.theme.FJAssistantTheme
import com.fj.assistant.viewmodel.MainViewModel
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Initialize Timber logging
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        
        setContent {
            FJAssistantTheme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {
    val mainViewModel: MainViewModel = viewModel()
    var selectedTab by remember { mutableStateOf(0) } // 0 = Chat, 1 = Settings
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("FJ - Personal AI") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Chat, contentDescription = "Chat") },
                    label = { Text("Chat") },
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    alwaysShowLabel = true
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
                    label = { Text("Settings") },
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    alwaysShowLabel = true
                )
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (selectedTab) {
                0 -> ChatScreen(mainViewModel)
                1 -> SettingsScreen(mainViewModel)
            }
        }
    }
}
