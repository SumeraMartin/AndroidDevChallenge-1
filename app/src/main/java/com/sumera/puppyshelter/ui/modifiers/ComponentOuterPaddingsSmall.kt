package com.sumera.puppyshelter.ui.modifiers

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.Dp
import com.sumera.puppyshelter.ui.theme.base.DimensMaterialTheme

fun Modifier.componentOuterPaddingsSmall(
    top: Dp? = null,
    bottom: Dp? = null,
    start: Dp? = null,
    end: Dp? = null,
) = composed {
    padding(
        top = top ?: DimensMaterialTheme.dimens.componentOuterVerticalPaddingsSmall,
        bottom = bottom ?: DimensMaterialTheme.dimens.componentOuterVerticalPaddingsSmall,
        start = start ?: DimensMaterialTheme.dimens.componentOuterHorizontalPaddingsSmall,
        end = end ?: DimensMaterialTheme.dimens.componentOuterHorizontalPaddingsSmall,
    )
}

fun Modifier.componentOuterVerticalPaddingsSmall(
    top: Dp? = null,
    bottom: Dp? = null,
) = composed {
    padding(
        top = top ?: DimensMaterialTheme.dimens.componentOuterVerticalPaddingsSmall,
        bottom = bottom ?: DimensMaterialTheme.dimens.componentOuterVerticalPaddingsSmall,
    )
}

fun Modifier.componentOuterHorizontalPaddingsSmall(
    start: Dp? = null,
    end: Dp? = null,
) = composed {
    padding(
        start = start ?: DimensMaterialTheme.dimens.componentOuterHorizontalPaddingsSmall,
        end = end ?: DimensMaterialTheme.dimens.componentOuterHorizontalPaddingsSmall,
    )
}
