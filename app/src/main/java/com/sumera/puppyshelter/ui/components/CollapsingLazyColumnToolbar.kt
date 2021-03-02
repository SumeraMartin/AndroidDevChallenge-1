package com.sumera.puppyshelter.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun CollapsingLazyColumnToolbar(
    expandedHeight: Dp,
    header: @Composable (scrollProgress: Float) -> Unit,
    lazyColumnContent: @Composable (state: LazyListState) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier) {
        val lazyListState = rememberLazyListState()
        val scrollProgress = calculateScrollProgress(expandedHeight, lazyListState)

        lazyColumnContent(lazyListState)
        header(scrollProgress)
    }
}

@Composable
private fun calculateScrollProgress(height: Dp, state: LazyListState): Float {
    val itemIndex = state.firstVisibleItemIndex
    val scrollOffset = state.firstVisibleItemScrollOffset
    val sizePx = with(LocalDensity.current) { height.toPx() }
    return if (itemIndex == 0) 1f - (scrollOffset / sizePx) else 0f
}
