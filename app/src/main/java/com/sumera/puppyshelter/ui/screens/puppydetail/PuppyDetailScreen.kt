package com.sumera.puppyshelter.ui.screens.puppydetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sumera.puppyshelter.ui.components.CollapsingScrollToolbar
import com.sumera.puppyshelter.ui.modifiers.componentOuterVerticalPaddings
import com.sumera.puppyshelter.ui.modifiers.screenHorizontalPaddings
import com.sumera.puppyshelter.ui.navigation.Navigator
import com.sumera.puppyshelter.ui.screens.puppydetail.components.PuppyDetailCollapsingHeader
import com.sumera.puppyshelter.ui.screens.puppydetail.logic.BackButtonClickedAction
import com.sumera.puppyshelter.ui.screens.puppydetail.logic.PuppyDetailAction
import com.sumera.puppyshelter.ui.screens.puppydetail.logic.PuppyDetailCoreactor
import com.sumera.puppyshelter.ui.screens.puppydetail.logic.PuppyDetailState

@Composable
fun PuppyDetailScreen(puppyId: String, navigator: Navigator) {
    val viewModel = viewModel<PuppyDetailCoreactor>()
    viewModel.navigator = navigator
    viewModel.puppyId = puppyId
    val state = viewModel.stateFlow.collectAsState()

    PuppyDetailScreenContent(state.value, viewModel.actionReceiver)
}

@Composable
fun PuppyDetailScreenContent(state: PuppyDetailState, onAction: (PuppyDetailAction) -> Unit) {
    if (state.puppy == null) {
        return
    }
    val puppy = state.puppy
    CollapsingScrollToolbar(
        expandedHeight = headerExpandedHeight,
        header = { scrollProgress ->
            PuppyDetailCollapsingHeader(
                title = puppy.name,
                imageUrl = puppy.imageUrl,
                scrollProgress = scrollProgress,
                expandedHeight = headerExpandedHeight,
                collapsedHeight = headerCollapsedHeight,
                onCloseClicked = { onAction(BackButtonClickedAction) },
            )
        },
        scrollContent = { scrollState ->
            Column(Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .wrapContentHeight()
                .screenHorizontalPaddings()
                .componentOuterVerticalPaddings()
            ) {
                Box(Modifier.padding(top = headerExpandedHeight))
                Text(
                    text = puppy.description,
                    style = MaterialTheme.typography.body1.copy(
                        color = MaterialTheme.colors.onBackground,
                        fontWeight = FontWeight.Light
                    )
                )
            }
        },
        modifier = Modifier
            .fillMaxSize()
    )
}

private val headerExpandedHeight = 240.dp
private val headerCollapsedHeight = 56.dp
