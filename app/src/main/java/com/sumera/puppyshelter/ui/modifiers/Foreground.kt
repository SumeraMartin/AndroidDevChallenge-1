package com.sumera.puppyshelter.ui.modifiers

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color

/**
 * A [Modifier] which draws a vertical gradient
 */
fun Modifier.foreground(color: Color): Modifier = drawWithContent {
    drawContent()
    drawRect(color)
}