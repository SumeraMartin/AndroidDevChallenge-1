package com.sumera.puppyshelter.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LazyColumnWithPaddings(
    topPadding: Dp,
    modifier: Modifier = Modifier,
    bottomPadding: Dp = 0.dp,
    state: LazyListState = rememberLazyListState(),
    content: LazyListScope.() -> Unit
) {
    LazyColumn(state = state, modifier = modifier) {
        item { VerticalSpace(topPadding) }
        content()
        item { VerticalSpace(bottomPadding) }
    }
}
