package com.shadowstrike.survival.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shadowstrike.survival.game.SettingsRepository

@Composable
fun MainMenuScreen(
    onStartMission: (Int) -> Unit,
    settingsRepo: SettingsRepository
) {
    var showSettings by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A0F1D)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "SHADOW STRIKE",
                fontSize = 42.sp,
                fontWeight = FontWeight.Black,
                color = Color(0xFF38BDF8),
                letterSpacing = 4.sp
            )
            Text(
                text = "SURVIVAL: TACTICAL SPEC-OPS",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFBBF24),
                letterSpacing = 6.sp
            )

            Spacer(modifier = Modifier.height(36.dp))

            Button(
                onClick = { onStartMission(1) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.width(260.dp).height(50.dp)
            ) {
                Text("DEPLOY MISSION 1", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(14.dp))

            OutlinedButton(
                onClick = { showSettings = true },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.width(260.dp).height(46.dp)
            ) {
                Text("SETTINGS & QUALITY", color = Color(0xFF94A3B8))
            }
        }
    }
}
