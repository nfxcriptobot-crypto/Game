package com.shadowstrike.survival.game

import android.content.Context
import android.content.SharedPreferences

class SettingsRepository(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("shadow_strike_prefs", Context.MODE_PRIVATE)

    var graphicsQuality: String
        get() = prefs.getString("graphics_quality", "HIGH") ?: "HIGH"
        set(value) = prefs.edit().putString("graphics_quality", value).apply()

    var sfxVolume: Float
        get() = prefs.getFloat("sfx_volume", 0.9f)
        set(value) = prefs.edit().putFloat("sfx_volume", value).apply()

    var musicVolume: Float
        get() = prefs.getFloat("music_volume", 0.5f)
        set(value) = prefs.edit().putFloat("music_volume", value).apply()

    var bestScore: Int
        get() = prefs.getInt("best_score", 0)
        set(value) = prefs.edit().putInt("best_score", value).apply()
}
