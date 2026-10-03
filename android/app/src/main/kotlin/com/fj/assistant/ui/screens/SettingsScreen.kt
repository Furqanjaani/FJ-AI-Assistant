package com.fj.assistant.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fj.assistant.viewmodel.MainViewModel

@Composable
fun SettingsScreen(viewModel: MainViewModel) {
    val appState = viewModel.state.collectAsState()
    val currentState = appState.value
    
    var showAIModeMenu by remember { mutableStateOf(false) }
    var showLanguageMenu by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                "\ud83e\udd16 AI Settings",
                style = MaterialTheme.typography.headlineSmall
            )
        }

        // AI Mode Selection
        item {
            Box {
                OutlinedButton(
                    onClick = { showAIModeMenu = true },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterVertically),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            "AI Mode",
                            style = MaterialTheme.typography.labelMedium
                        )
                        Text(
                            currentState.aiMode,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }

                DropdownMenu(
                    expanded = showAIModeMenu,
                    onDismissRequest = { showAIModeMenu = false }
                ) {
                    listOf("OFFLINE", "ONLINE", "HYBRID").forEach { mode ->
                        DropdownMenuItem(
                            text = { Text(mode) },
                            onClick = {
                                viewModel.setAIMode(mode)
                                showAIModeMenu = false
                            },
                            trailingIcon = {
                                if (mode == currentState.aiMode) {
                                    Icon(Icons.Default.Check, contentDescription = null)
                                }
                            }
                        )
                    }
                }
            }
        }

        // Language Selection
        item {
            Box {
                OutlinedButton(
                    onClick = { showLanguageMenu = true },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterVertically),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            "Language",
                            style = MaterialTheme.typography.labelMedium
                        )
                        Text(
                            currentState.language,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }

                DropdownMenu(
                    expanded = showLanguageMenu,
                    onDismissRequest = { showLanguageMenu = false }
                ) {
                    listOf("Urdu", "English", "Urdu+English").forEach { lang ->
                        DropdownMenuItem(
                            text = { Text(lang) },
                            onClick = {
                                viewModel.setLanguage(lang)
                                showLanguageMenu = false
                            },
                            trailingIcon = {
                                if (lang == currentState.language) {
                                    Icon(Icons.Default.Check, contentDescription = null)
                                }
                            }
                        )
                    }
                }
            }
        }

        // Features Section
        item {
            Text(
                "\u2728 Features",
                style = MaterialTheme.typography.headlineSmall
            )
        }

        // Emotion Engine Toggle
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        "Emotion Engine",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        "Detect emotions",
                        style = MaterialTheme.typography.labelSmall
                    )
                }
                Switch(
                    checked = currentState.emotionEngineEnabled,
                    onCheckedChange = { viewModel.toggleEmotionEngine(it) }
                )
            }
        }

        // Security Toggle
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        "Security & Anti-Theft",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        "Device protection",
                        style = MaterialTheme.typography.labelSmall
                    )
                }
                Switch(
                    checked = currentState.securityEnabled,
                    onCheckedChange = { viewModel.toggleSecurity(it) }
                )
            }
        }

        // Model Download Button
        item {
            Button(
                onClick = { /* Download model */ },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("\ud83d\udcca Download TinyLlama Model")
            }
        }

        // Clear Chat Button
        item {
            OutlinedButton(
                onClick = { viewModel.clearMessages() },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Clear Chat History")
            }
        }

        item {
            Text(
                "FJ v1.0.0 | Personal AI Assistant",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    }
}
