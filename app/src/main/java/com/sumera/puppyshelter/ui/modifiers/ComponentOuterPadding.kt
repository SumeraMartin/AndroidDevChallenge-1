package com.sumera.puppyshelter.ui.modifiers

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.Dp
import com.sumera.puppyshelter.ui.theme.base.DimensMaterialTheme

fun Modifier.componentOuterPaddings(
    top: Dp? = null,
    bottom: Dp? = null,
    start: Dp? = null,
    end: Dp? = null,
) = composed {
    padding(
        top = top ?: DimensMaterialTheme.dimens.componentOuterVerticalPaddings,
        bottom = bottom ?: DimensMaterialTheme.dimens.componentOuterVerticalPaddings,
        start = start ?: DimensMaterialTheme.dimens.componentOuterHorizontalPaddings,
        end = end ?: DimensMaterialTheme.dimens.componentOuterHorizontalPaddings,
    )
}

fun Modifier.componentOuterVerticalPaddings(
    top: Dp? = null,
    bottom: Dp? = null,
) = composed {
    padding(
        top = top ?: DimensMaterialTheme.dimens.componentOuterVerticalPaddings,
        bottom = bottom ?: DimensMaterialTheme.dimens.componentOuterVerticalPaddings,
    )
}

fun Modifier.componentOuterHorizontalPaddings(
    start: Dp? = null,
    end: Dp? = null,
) = composed {
    padding(
        start = start ?: DimensMaterialTheme.dimens.componentOuterHorizontalPaddings,
        end = end ?: DimensMaterialTheme.dimens.componentOuterHorizontalPaddings,
    )
}
