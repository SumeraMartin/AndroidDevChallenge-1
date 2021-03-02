package com.sumera.puppyshelter.ui.modifiers

import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer

@Stable
fun Modifier.scale(
    scale: Float,
    pivotX: Float = centerX,
    pivotY: Float = centerY,
) = graphicsLayer(
    scaleX = scale,
    scaleY = scale,
    transformOrigin = TransformOrigin(pivotX, pivotY)
)

private const val centerX = 0.5f
private const val centerY = 0.5f
