package com.shadowstrike.survival.game

data class PlayerState(
    var x: Float = 0f,
    var y: Float = 0f,
    var z: Float = 24f,
    var yaw: Float = 0f,
    var pitch: Float = 0f,
    var health: Int = 100,
    var armor: Int = 50,
    var ammo: Int = 30,
    var reserveAmmo: Int = 120,
    var isAlive: Boolean = true
)

class PlayerController {
    val state = PlayerState()

    fun updateMovement(forward: Float, right: Float, delta: Float) {
        val speed = 5.5f
        val rad = Math.toRadians(state.yaw.toDouble())
        state.x += (Math.cos(rad) * right - Math.sin(rad) * forward).toFloat() * speed * delta
        state.z += (-Math.sin(rad) * right - Math.cos(rad) * forward).toFloat() * speed * delta
    }
}
