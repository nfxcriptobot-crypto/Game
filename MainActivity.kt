package com.shadowstrike.survival

import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.shadowstrike.survival.ui.MainMenuScreen
import com.shadowstrike.survival.ui.GameScreen
import com.shadowstrike.survival.game.SettingsRepository

enum class ScreenState {
    MAIN_MENU,
    IN_GAME
}

class MainActivity : ComponentActivity() {
    private lateinit var settingsRepo: SettingsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        settingsRepo = SettingsRepository(this)
        hideSystemUI()

        setContent {
            var currentScreen by remember { mutableStateOf(ScreenState.MAIN_MENU) }
            var selectedMission by remember { mutableIntStateOf(1) }

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFF0A0F1D)
            ) {
                when (currentScreen) {
                    ScreenState.MAIN_MENU -> {
                        MainMenuScreen(
                            onStartMission = { missionId ->
                                selectedMission = missionId
                                currentScreen = ScreenState.IN_GAME
                            },
                            settingsRepo = settingsRepo
                        )
                    }
                    ScreenState.IN_GAME -> {
                        GameScreen(
                            missionId = selectedMission,
                            settingsRepo = settingsRepo,
                            onReturnToMenu = {
                                currentScreen = ScreenState.MAIN_MENU
                            }
                        )
                    }
                }
            }
        }
    }

    private fun hideSystemUI() {
        window.decorView.systemUiVisibility = (
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_FULLSCREEN
        )
    }
}
