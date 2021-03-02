package com.sumera.puppyshelter.ui.screens.puppylist

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sumera.puppyshelter.ui.components.CollapsingLazyColumnToolbar
import com.sumera.puppyshelter.ui.modifiers.foreground
import com.sumera.puppyshelter.ui.navigation.Navigator
import com.sumera.puppyshelter.ui.screens.puppylist.components.PuppyCollapsingHeader
import com.sumera.puppyshelter.ui.screens.puppylist.components.bottomsheet.FilterBottomSheet
import com.sumera.puppyshelter.ui.screens.puppylist.components.PuppyListContent
import com.sumera.puppyshelter.ui.screens.puppylist.logic.OnBreedFilterToggleAction
import com.sumera.puppyshelter.ui.screens.puppylist.logic.OnPuppyClickedAction
import com.sumera.puppyshelter.ui.screens.puppylist.logic.OnTryAgainClickAction
import com.sumera.puppyshelter.ui.screens.puppylist.logic.PuppyListAction
import com.sumera.puppyshelter.ui.screens.puppylist.logic.PuppyListCoreactor
import com.sumera.puppyshelter.ui.screens.puppylist.logic.state.PuppyListState
import com.sumera.puppyshelter.ui.theme.base.DimensMaterialTheme
import com.sumera.puppyshelter.ui.utils.animations.colorOnBooleanAnimation
import kotlinx.coroutines.launch

@Composable
fun PuppyListScreen(navigator: Navigator) {
    val viewModel = viewModel<PuppyListCoreactor>()
    viewModel.navigator = navigator

    val state = viewModel.stateFlow.collectAsState()

    PuppyListScreenContent(state.value, viewModel.actionReceiver)
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun PuppyListScreenContent(state: PuppyListState, onAction: (PuppyListAction) -> Unit) {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()

    val sheetPeekHeight = calculatePeekHeight(state)
    val bottomSheetContentOverlayColor = calculateOverlayColor(scaffoldState)

    BottomSheetScaffold(
        sheetElevation = bottomSheetElevation,
        scaffoldState = scaffoldState,
        sheetPeekHeight = sheetPeekHeight,
        sheetContent = {
            FilterBottomSheet(
                state = state.filter,
                headerHeight = activeBottomSheetFilterHeight,
                onBreedCheckboxClicked = { breed ->
                    onAction(OnBreedFilterToggleAction(breed))
                }
            )
        },
        content = {
            CollapsingLazyColumnToolbar(
                expandedHeight = headerExpandedHeight,
                header = { scrollProgress ->
                    PuppyCollapsingHeader(
                        scrollProgress = scrollProgress,
                        expandedHeight = headerExpandedHeight,
                        collapsedHeight = headerCollapsedHeight,
                        onFilterClicked = { scope.launch { scaffoldState.bottomSheetState.expand() } },
                    )
                },
                lazyColumnContent = { lazyListState ->
                    PuppyListContent(
                        state = state.puppiesState,
                        lazyListState = lazyListState,
                        visibleBreeds = state.filter.visibleBreeds,
                        topPadding = headerExpandedHeight,
                        onTryAgainClicked = { onAction(OnTryAgainClickAction) },
                        onPuppyClicked = { onAction(OnPuppyClickedAction(it)) },
                        contentModifier = Modifier.padding(top = DimensMaterialTheme.dimens.screenVerticalPaddings,bottom = sheetPeekHeight)
                    )
                },
                modifier = Modifier.foreground(bottomSheetContentOverlayColor)
            )
        }
    )
}

private fun calculatePeekHeight(state: PuppyListState) = if (state.filter.breeds.isEmpty()) {
    inactiveBottomSheetFilterHeight
} else {
    activeBottomSheetFilterHeight
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun calculateOverlayColor(scaffoldState: BottomSheetScaffoldState): Color {
    val isBottomSheetExpanding = scaffoldState.bottomSheetState.targetValue == BottomSheetValue.Expanded
    return colorOnBooleanAnimation(
        initialValue = overlayColor.copy(alpha = 0f),
        targetValue = overlayColor.copy(alpha = 0.4f),
        isTargetValue = isBottomSheetExpanding,
    )
}


private val overlayColor = Color.Black
private val activeBottomSheetFilterHeight = 72.dp
private val inactiveBottomSheetFilterHeight = 0.dp
private val headerExpandedHeight = 240.dp
private val headerCollapsedHeight = 56.dp
private val bottomSheetElevation = 24.dp
