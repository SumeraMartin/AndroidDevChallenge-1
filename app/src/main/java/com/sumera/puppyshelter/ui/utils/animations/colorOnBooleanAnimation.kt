package com.sumera.puppyshelter.ui.utils.animations

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

@Composable
fun colorOnBooleanAnimation(
    initialValue: Color,
    targetValue: Color,
    isTargetValue: Boolean,
) : Color {
    val targetColor = if (isTargetValue) targetValue else initialValue
    val animatedColor = remember { Animatable(targetColor) }
    LaunchedEffect(targetColor, tween<Float>()) {
        animatedColor.animateTo(targetColor)
    }

    return animatedColor.value
}
