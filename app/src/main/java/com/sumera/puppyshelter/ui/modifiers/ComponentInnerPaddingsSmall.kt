package com.sumera.puppyshelter.ui.modifiers

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.Dp
import com.sumera.puppyshelter.ui.theme.base.DimensMaterialTheme

fun Modifier.componentInnerPaddingsSmall(
    top: Dp? = null,
    bottom: Dp? = null,
    start: Dp? = null,
    end: Dp? = null,
) = composed {
    padding(
        top = top ?: DimensMaterialTheme.dimens.componentInnerVerticalPaddingsSmall,
        bottom = bottom ?: DimensMaterialTheme.dimens.componentInnerVerticalPaddingsSmall,
        start = start ?: DimensMaterialTheme.dimens.componentInnerHorizontalPaddingsSmall,
        end = end ?: DimensMaterialTheme.dimens.componentInnerHorizontalPaddingsSmall,
    )
}

fun Modifier.componentInnerVerticalPaddingsSmall(
    top: Dp? = null,
    bottom: Dp? = null,
) = composed {
    padding(
        top = top ?: DimensMaterialTheme.dimens.componentInnerVerticalPaddingsSmall,
        bottom = bottom ?: DimensMaterialTheme.dimens.componentInnerVerticalPaddingsSmall,
    )
}

fun Modifier.componentInnerHorizontalPaddingsSmall(
    start: Dp? = null,
    end: Dp? = null,
) = composed {
    padding(
        start = start ?: DimensMaterialTheme.dimens.componentInnerHorizontalPaddingsSmall,
        end = end ?: DimensMaterialTheme.dimens.componentInnerHorizontalPaddingsSmall,
    )
}