package com.sumera.puppyshelter.ui.screens.puppylist.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Filter
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.sumera.puppyshelter.R
import com.sumera.puppyshelter.ui.components.NetworkImage
import com.sumera.puppyshelter.ui.modifiers.scale
import com.sumera.puppyshelter.ui.modifiers.screenHorizontalPaddings
import com.sumera.puppyshelter.ui.modifiers.scrim
import com.sumera.puppyshelter.ui.theme.base.DimensMaterialTheme
import com.sumera.puppyshelter.ui.utils.animations.colorOnBooleanAnimation

@Composable
fun PuppyCollapsingHeader(
    scrollProgress: Float,
    expandedHeight: Dp,
    collapsedHeight: Dp,
    onFilterClicked: () -> Unit,
    expandedElevation: Dp = DimensMaterialTheme.dimens.elevation,
    collapsedElevation: Dp = 0.dp,
    expandedStartPadding: Dp = DimensMaterialTheme.dimens.screenHorizontalPaddings,
    collapsedStartPadding: Dp = DimensMaterialTheme.dimens.screenHorizontalPaddings,
    expandedTitleSize: TextUnit = MaterialTheme.typography.h4.fontSize,
    collapsedTitleSize: TextUnit = MaterialTheme.typography.h6.fontSize,
    toolbarColor: Color = MaterialTheme.colors.primary,
    toolbarTintExpandedColor: Color = MaterialTheme.colors.onBackground,
    toolbarTintCollapsedColor: Color = MaterialTheme.colors.onPrimary,
) {
    val height = calculateHeight(scrollProgress, expandedHeight, collapsedHeight)
    val elevation = calculateElevation(scrollProgress, expandedElevation, collapsedElevation)
    val titleSizeScale = calculateTitleSizeScale(scrollProgress, expandedTitleSize, collapsedTitleSize)
    val startPadding = calculateStartPadding(scrollProgress, expandedStartPadding, collapsedStartPadding)
    val toolbarColor = calculateToolbarColor(scrollProgress, toolbarColor)
    val toolbarTintColor = calculateToolbarTintColor(scrollProgress, toolbarTintExpandedColor, toolbarTintCollapsedColor)

    Card(
        elevation = elevation,
        shape = RectangleShape,
        modifier = Modifier
            .height(height)
            .fillMaxWidth()
    ) {
        NetworkImage(
            url = "https://thumbs.dreamstime.com/b/border-collie-puppy-dogs-running-downhill-playing-puppies-running-grass-under-sunlight-cute-puppy-background-103985091.jpg",
            contentDescription = "Title image",
            backgroundColor = MaterialTheme.colors.background,
            modifier = Modifier
                .fillMaxWidth()
                .height(expandedHeight)
        )
        Box(
            contentAlignment = Alignment.CenterStart,
        ) {
            Box(Modifier
                .fillMaxWidth()
                .height(60.dp)
                .align(Alignment.BottomCenter)
                .scrim(listOf(MaterialTheme.colors.background.copy(alpha = 0f), MaterialTheme.colors.background))
            )
        }
        Surface(
            color = toolbarColor,
            modifier = Modifier
                .fillMaxSize()
        ) {}
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .padding(start = startPadding)
        ) {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .height(collapsedHeight)
                    .align(Alignment.BottomStart),
            ) {
                Text(
                    text = LocalContext.current.getString(R.string.app_name),
                    style = MaterialTheme.typography.h4.copy(fontSize = expandedTitleSize, color = toolbarTintColor),
                    modifier = Modifier
                        .scale(scale = titleSizeScale, pivotX = 0f)
                )
            }

            Box(Modifier.height(collapsedHeight).align(Alignment.TopEnd).screenHorizontalPaddings()) {
                IconButton(modifier = Modifier.align(Alignment.CenterEnd), onClick = { onFilterClicked() }) {
                    Icon(Icons.Filled.FilterList, contentDescription = "Filter", tint = toolbarTintColor)
                }
            }
        }
    }
}

private fun calculateHeight(scrollProgress: Float, expandedHeight: Dp, collapsedHeight: Dp): Dp {
    val calculatedHeight = expandedHeight * scrollProgress
    return max(calculatedHeight, collapsedHeight)
}

private fun calculateElevation(scrollProgress: Float, expandedElevation: Dp, collapsedElevation: Dp): Dp {
    val calculatedElevation = expandedElevation * (1f - scrollProgress)
    return max(calculatedElevation, collapsedElevation)
}

private fun calculateStartPadding(scrollProgress: Float, expandedStartPadding: Dp, collapsedStartPadding: Dp): Dp {
    val difference = expandedStartPadding - collapsedStartPadding
    return collapsedStartPadding + difference * scrollProgress
}

private fun calculateTitleSizeScale(scrollProgress: Float, expandedTitleSize: TextUnit, collapsedTitleSize: TextUnit): Float {
    val difference = collapsedTitleSize.value / expandedTitleSize.value
    return difference + ((1f - difference) * scrollProgress)
}

private fun calculateToolbarColor(scrollProgress: Float, color: Color): Color {
    return color.copy(alpha = 1f - scrollProgress)
}

@Composable
private fun calculateToolbarTintColor(scrollProgress: Float, expandedColor: Color, collapsedColor: Color): Color {
    return colorOnBooleanAnimation(expandedColor, collapsedColor, scrollProgress < 0.5f)
}

