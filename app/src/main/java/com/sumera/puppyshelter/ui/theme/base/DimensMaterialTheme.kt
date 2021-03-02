package com.sumera.puppyshelter.ui.theme.base

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun DimensMaterialTheme(
    colors: Colors = MaterialTheme.colors,
    typography: Typography = MaterialTheme.typography,
    shapes: Shapes = MaterialTheme.shapes,
    dimens: Dimens = DimensMaterialTheme.dimens,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalDimens provides dimens
    ) {
        MaterialTheme(
            colors = colors,
            typography = typography,
            shapes = shapes,
        ) {
            content()
        }
    }
}

object DimensMaterialTheme {

    val dimens: Dimens
        @Composable
        @ReadOnlyComposable
        get() = LocalDimens.current
}