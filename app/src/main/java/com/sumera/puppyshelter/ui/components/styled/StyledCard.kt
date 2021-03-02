package com.sumera.puppyshelter.ui.components.styled

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sumera.puppyshelter.ui.modifiers.clickable
import com.sumera.puppyshelter.ui.theme.base.DimensMaterialTheme
import com.sumera.puppyshelter.ui.utils.animations.floatOnPressedAnimation

@Composable
fun StyledCard(
    modifier: Modifier = Modifier,
    contentModifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClicked: () -> Unit = {},
    content: @Composable () -> Unit,
) {
    Card(
        elevation = elevationAnimation(interactionSource),
        modifier = modifier
            .scale(scaleAnimation(interactionSource))
            .clickable(
                interactionSource = interactionSource,
                onClick = onClicked
            )
    ) {
        Box(
            modifier = contentModifier.fillMaxWidth(),
        ) {
            content()
        }
    }
}

@Composable
private fun elevationAnimation(
    interactionSource: MutableInteractionSource
): Dp {
    val normalElevation = DimensMaterialTheme.dimens.elevation
    val pressedElevation = DimensMaterialTheme.dimens.pressedElevation
    val elevation = floatOnPressedAnimation(normalElevation.value, pressedElevation.value, interactionSource)
    return elevation.value.dp
}

@Composable
private fun scaleAnimation(
    interactionSource: MutableInteractionSource
): Float {
    val normalScale = 1f
    val pressedScale = 0.95f
    val elevation = floatOnPressedAnimation(normalScale, pressedScale, interactionSource)
    return elevation.value
}

@Preview
@Composable
fun StyledCardPreview() {
    StyledCard {
        Text("Preview")
    }
}