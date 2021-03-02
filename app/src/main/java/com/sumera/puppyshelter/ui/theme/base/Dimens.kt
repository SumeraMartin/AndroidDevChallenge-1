package com.sumera.puppyshelter.ui.theme.base

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class Dimens(
    elevation: Dp,
    pressedElevation: Dp,
    screenVerticalPaddings: Dp,
    screenHorizontalPaddings: Dp,
    componentInnerVerticalPaddings: Dp,
    componentInnerHorizontalPaddings: Dp,
    componentOuterVerticalPaddings: Dp,
    componentOuterHorizontalPaddings: Dp,
    componentInnerVerticalPaddingsSmall: Dp,
    componentInnerHorizontalPaddingsSmall: Dp,
    componentOuterVerticalPaddingsSmall: Dp,
    componentOuterHorizontalPaddingsSmall: Dp,
    smallIconSize: Dp,
    normalIconSize: Dp,
    iconTextSpace: Dp,
) {
    var elevation by mutableStateOf(elevation)
        internal set
    var pressedElevation by mutableStateOf(pressedElevation)
        internal set
    var screenVerticalPaddings by mutableStateOf(screenVerticalPaddings)
        internal set
    var screenHorizontalPaddings by mutableStateOf(screenHorizontalPaddings)
        internal set
    var componentInnerVerticalPaddings by mutableStateOf(componentInnerVerticalPaddings)
        internal set
    var componentInnerHorizontalPaddings by mutableStateOf(componentInnerHorizontalPaddings)
        internal set
    var componentOuterVerticalPaddings by mutableStateOf(componentOuterVerticalPaddings)
        internal set
    var componentOuterHorizontalPaddings by mutableStateOf(componentOuterHorizontalPaddings)
        internal set
    var componentInnerVerticalPaddingsSmall by mutableStateOf(componentInnerVerticalPaddingsSmall)
        internal set
    var componentInnerHorizontalPaddingsSmall by mutableStateOf(componentInnerHorizontalPaddingsSmall)
        internal set
    var componentOuterVerticalPaddingsSmall by mutableStateOf(componentOuterVerticalPaddingsSmall)
        internal set
    var componentOuterHorizontalPaddingsSmall by mutableStateOf(componentOuterHorizontalPaddingsSmall)
        internal set
    var smallIconSize by mutableStateOf(smallIconSize)
        internal set
    var normalIconSize by mutableStateOf(normalIconSize)
        internal set
    var iconTextSpace by mutableStateOf(iconTextSpace)
        internal set
}

fun defaultPaddings() = Dimens(
    elevation = 1.dp,
    pressedElevation = 0.dp,
    screenVerticalPaddings = 8.dp,
    screenHorizontalPaddings = 8.dp,
    componentInnerVerticalPaddings = 8.dp,
    componentInnerHorizontalPaddings = 8.dp,
    componentOuterVerticalPaddings = 8.dp,
    componentOuterHorizontalPaddings = 8.dp,
    componentInnerVerticalPaddingsSmall = 4.dp,
    componentInnerHorizontalPaddingsSmall = 4.dp,
    componentOuterVerticalPaddingsSmall = 4.dp,
    componentOuterHorizontalPaddingsSmall = 4.dp,
    smallIconSize = 16.dp,
    normalIconSize = 24.dp,
    iconTextSpace = 8.dp,
)

internal val LocalDimens = staticCompositionLocalOf { defaultPaddings() }
