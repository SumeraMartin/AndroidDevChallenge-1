package com.sumera.puppyshelter.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.sumera.puppyshelter.ui.theme.base.DimensMaterialTheme
import com.sumera.puppyshelter.ui.theme.values.dimens
import com.sumera.puppyshelter.ui.theme.values.green
import com.sumera.puppyshelter.ui.theme.values.greenDark
import com.sumera.puppyshelter.ui.theme.values.greenLight
import com.sumera.puppyshelter.ui.theme.values.purple200
import com.sumera.puppyshelter.ui.theme.values.purple500
import com.sumera.puppyshelter.ui.theme.values.purple700
import com.sumera.puppyshelter.ui.theme.values.shapes
import com.sumera.puppyshelter.ui.theme.values.teal200
import com.sumera.puppyshelter.ui.theme.values.typography

private val DarkColorPalette = darkColors(
    primary = green,
    primaryVariant = greenDark,
    secondary = greenLight
)

private val LightColorPalette = lightColors(
    primary = green,
    primaryVariant = greenDark,
    secondary = greenLight

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun PuppyShelterTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    DimensMaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        dimens = dimens,
        content = content
    )
}
