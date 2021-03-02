package com.sumera.puppyshelter.ui.modifiers

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.Dp
import com.sumera.puppyshelter.ui.theme.base.DimensMaterialTheme

fun Modifier.screenHorizontalPaddings(
    start: Dp? = null,
    end: Dp? = null,
) = composed {
    padding(
        start = start ?: DimensMaterialTheme.dimens.screenHorizontalPaddings,
        end = end ?: DimensMaterialTheme.dimens.screenHorizontalPaddings,
    )
}
