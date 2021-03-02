package com.sumera.puppyshelter.ui.screens.puppylist.components.bottomsheet

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import com.sumera.puppyshelter.R
import com.sumera.puppyshelter.tools.format.formatName
import com.sumera.puppyshelter.ui.components.styled.StyledChip
import com.sumera.puppyshelter.ui.components.styled.StyledDivider
import com.sumera.puppyshelter.ui.data.Breed
import com.sumera.puppyshelter.ui.modifiers.indexedVerticalComponentPadding
import com.sumera.puppyshelter.ui.modifiers.screenHorizontalPaddings

@Composable
fun FilterBottomSheetHeader(
    filteredBreeds: List<Breed>,
    onCloseClicked: (Breed) -> Unit,
    height: Dp,
    modifier: Modifier = Modifier,
) {
    Column {
        Box(
            modifier.fillMaxWidth().heightIn(min = height),
            contentAlignment = Alignment.CenterStart
        ) {
            if (filteredBreeds.isEmpty()) {
                Text(
                    text = LocalContext.current.getString(R.string.filter_title),
                    style = MaterialTheme.typography.h6.copy(
                        color = MaterialTheme.colors.onSurface,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier.screenHorizontalPaddings()
                )
            } else {
                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState())
                ) {
                    filteredBreeds.reversed().forEachIndexed { index, breed ->
                        StyledChip(
                            text = breed.formatName(LocalContext.current),
                            onClick = { onCloseClicked(breed) },
                            modifier = Modifier.indexedVerticalComponentPadding(index, filteredBreeds.size)
                        )
                    }
                }
            }
        }
        StyledDivider()
    }
}
