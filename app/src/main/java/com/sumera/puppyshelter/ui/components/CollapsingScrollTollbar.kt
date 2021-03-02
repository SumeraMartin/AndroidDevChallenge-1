package com.sumera.puppyshelter.ui.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import kotlin.math.max

@Composable
fun CollapsingScrollToolbar(
    expandedHeight: Dp,
    header: @Composable (scrollProgress: Float) -> Unit,
    scrollContent: @Composable (state: ScrollState) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier) {
        val scrollState = rememberScrollState()
        val scrollProgress = calculateScrollProgress(expandedHeight, scrollState)

        scrollContent(scrollState)
        header(scrollProgress)
    }
}

@Composable
private fun calculateScrollProgress(height: Dp, state: ScrollState): Float {
    val heightPx = with(LocalDensity.current) { height.toPx() }
    return max(0f, 1f - state.value / heightPx)
}
