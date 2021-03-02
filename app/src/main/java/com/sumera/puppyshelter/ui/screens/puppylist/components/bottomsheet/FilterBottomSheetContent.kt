package com.sumera.puppyshelter.ui.screens.puppylist.components.bottomsheet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sumera.puppyshelter.tools.format.formatName
import com.sumera.puppyshelter.ui.components.styled.StyledDivider
import com.sumera.puppyshelter.ui.data.Breed
import com.sumera.puppyshelter.ui.modifiers.componentInnerPaddings
import com.sumera.puppyshelter.ui.modifiers.componentInnerVerticalPaddings
import com.sumera.puppyshelter.ui.modifiers.screenHorizontalPaddings
import com.sumera.puppyshelter.ui.screens.puppylist.logic.state.FilterState

@Composable
fun FilterBottomSheetContent(
    state: FilterState,
    onBreedCheckboxClicked: (Breed) -> Unit
) {
    LazyColumn(
        Modifier.fillMaxWidth()
    ) {
        items(Breed.values()) { breed ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onBreedCheckboxClicked(breed) }
                    .screenHorizontalPaddings()
                    .componentInnerVerticalPaddings()
            ){
                Text(
                    text = breed.formatName(LocalContext.current),
                    style = MaterialTheme.typography.body1.copy(
                        color = MaterialTheme.colors.onBackground,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Checkbox(
                    checked = breed in state.breeds,
                    onCheckedChange = {
                        onBreedCheckboxClicked(breed)
                    },
                    Modifier.align(Alignment.CenterEnd)
                )
            }
            StyledDivider()
        }
    }
}