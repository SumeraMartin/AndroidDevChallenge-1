package com.sumera.puppyshelter.ui.modifiers

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.Dp
import com.sumera.puppyshelter.ui.theme.base.DimensMaterialTheme

fun Modifier.componentInnerPaddings(
    top: Dp? = null,
    bottom: Dp? = null,
    start: Dp? = null,
    end: Dp? = null,
) = composed {
    padding(
        top = top ?: DimensMaterialTheme.dimens.componentInnerVerticalPaddings,
        bottom = bottom ?: DimensMaterialTheme.dimens.componentInnerVerticalPaddings,
        start = start ?: DimensMaterialTheme.dimens.componentInnerHorizontalPaddings,
        end = end ?: DimensMaterialTheme.dimens.componentInnerHorizontalPaddings,
    )
}

fun Modifier.componentInnerVerticalPaddings(
    top: Dp? = null,
    bottom: Dp? = null,
) = composed {
    padding(
        top = top ?: DimensMaterialTheme.dimens.componentInnerVerticalPaddings,
        bottom = bottom ?: DimensMaterialTheme.dimens.componentInnerVerticalPaddings,
    )
}

fun Modifier.componentInnerHorizontalPaddings(
    start: Dp? = null,
    end: Dp? = null,
) = composed {
    padding(
        start = start ?: DimensMaterialTheme.dimens.componentInnerHorizontalPaddings,
        end = end ?: DimensMaterialTheme.dimens.componentInnerHorizontalPaddings,
    )
}
