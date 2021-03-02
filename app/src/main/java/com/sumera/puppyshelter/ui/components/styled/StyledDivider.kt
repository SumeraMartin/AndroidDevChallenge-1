package com.sumera.puppyshelter.ui.components.styled

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sumera.puppyshelter.ui.theme.base.DimensMaterialTheme

@Composable
fun StyledDivider(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.onSurface.copy(alpha = DividerAlpha),
    thickness: Dp = 1.dp,
    indent: Dp = DimensMaterialTheme.dimens.screenHorizontalPaddings,
) {
    Box(
        modifier.padding(horizontal = indent)
            .fillMaxWidth()
            .height(thickness)
            .background(color = color)
    )
}

private const val DividerAlpha = 0.08f
