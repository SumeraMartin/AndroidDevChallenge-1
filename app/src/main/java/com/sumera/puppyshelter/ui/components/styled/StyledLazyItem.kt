package com.sumera.puppyshelter.ui.components.styled

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sumera.puppyshelter.ui.modifiers.componentOuterVerticalPaddings
import com.sumera.puppyshelter.ui.modifiers.screenHorizontalPaddings

@Composable
fun StyledLazyItem(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .screenHorizontalPaddings()
            .componentOuterVerticalPaddings(),
    ) {
        content()
    }
}

@Preview
@Composable
fun StyledLazyItemPreview() {
    StyledLazyItem {
        Text("Preview")
    }
}