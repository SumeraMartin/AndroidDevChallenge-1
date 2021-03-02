package com.sumera.puppyshelter.ui.components.generic

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorOverlay(
    isVisible: Boolean,
    modifier: Modifier = Modifier,
    color: Color = Color.Black.copy(alpha = alpha),
    content: @Composable () -> Unit
) {
    Box(modifier) {
        content()

        val targetColor = if (isVisible) color else color.copy(alpha = 0f)
        val animatedColor = remember { Animatable(targetColor) }
        LaunchedEffect(isVisible, tween<Float>()) {
            animatedColor.animateTo(targetColor)
        }
        Surface(modifier = Modifier.height(100.dp).fillMaxWidth(), color = animatedColor.value) {}
    }
}

private const val alpha = 0.5f
