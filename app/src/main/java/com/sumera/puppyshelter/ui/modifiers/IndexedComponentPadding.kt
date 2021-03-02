package com.sumera.puppyshelter.ui.modifiers

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.dp
import com.sumera.puppyshelter.ui.theme.base.DimensMaterialTheme

fun Modifier.indexedVerticalComponentPadding(
    index: Int,
    itemCount: Int,
) = composed {
    padding(
        start = if (index == 0) DimensMaterialTheme.dimens.screenHorizontalPaddings else DimensMaterialTheme.dimens.componentOuterHorizontalPaddings,
        end = if (index == itemCount - 1) DimensMaterialTheme.dimens.screenHorizontalPaddings else 0.dp,
    )
}
