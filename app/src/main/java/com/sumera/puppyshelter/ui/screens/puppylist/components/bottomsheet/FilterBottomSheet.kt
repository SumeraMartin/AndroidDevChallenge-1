package com.sumera.puppyshelter.ui.screens.puppylist.components.bottomsheet

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.sumera.puppyshelter.ui.data.Breed
import com.sumera.puppyshelter.ui.screens.puppylist.logic.state.FilterState

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun FilterBottomSheet(
    state: FilterState,
    headerHeight: Dp,
    onBreedCheckboxClicked: (Breed) -> Unit
) {
    Column {
        FilterBottomSheetHeader(
            filteredBreeds = state.breeds,
            onCloseClicked = onBreedCheckboxClicked,
            height = headerHeight,
        )
        FilterBottomSheetContent(
            state = state,
            onBreedCheckboxClicked = onBreedCheckboxClicked,
        )
    }
}
