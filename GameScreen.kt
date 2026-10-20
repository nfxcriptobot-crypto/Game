package com.shadowstrike.survival.ui

import android.opengl.GLSurfaceView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.shadowstrike.survival.game.SettingsRepository
import com.shadowstrike.survival.renderer.GameRenderer

@Composable
fun GameScreen(
    missionId: Int,
    settingsRepo: SettingsRepository,
    onReturnToMenu: () -> Unit
) {
    var health by remember { mutableIntStateOf(100) }
    var ammo by remember { mutableIntStateOf(30) }
    var kills by remember { mutableIntStateOf(0) }

    Box(modifier = Modifier.fillMaxSize()) {
        // 3D OpenGL ES Surface View
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                GLSurfaceView(context).apply {
                    setEGLContextClientVersion(3)
                    setRenderer(GameRenderer(context, missionId))
                    renderMode = GLSurfaceView.RENDERMODE_CONTINUOUSLY
                }
            }
        )

        // Tactical HUD Overlay
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            // Health & Shield
            Column {
                Text("HEALTH: $health%", color = Color(0xFF22C55E), fontWeight = FontWeight.Bold)
                Text("STATUS: SPEC-OPS ACTIVE", color = Color(0xFF94A3B8), fontSize = 12.sp)
            }

            // Mission Objective
            Surface(
                color = Color(0xAA0F172A),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "TARGETS ELIMINATED: $kills/5",
                    color = Color(0xFFFBBF24),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                )
            }

            // Ammo
            Text("AMMO: $ammo/120", color = Color(0xFF38BDF8), fontWeight = FontWeight.Bold)
        }

        // Touch Control Areas
        // Left Virtual Joystick Placeholder
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(24.dp)
                .size(120.dp)
                .background(Color(0x33FFFFFF), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Box(modifier = Modifier.size(48.dp).background(Color(0x8838BDF8), CircleShape))
        }

        // Right Fire & Action Buttons
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { /* Fire Weapon */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEF4444)),
                shape = CircleShape,
                modifier = Modifier.size(72.dp)
            ) {
                Text("FIRE", fontWeight = FontWeight.Black)
            }
        }
    }
}
