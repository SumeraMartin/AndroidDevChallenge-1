package com.sumera.puppyshelter.ui.screens.puppylist.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sumera.puppyshelter.ui.components.LazyColumnWithPaddings
import com.sumera.puppyshelter.ui.components.generic.loadingstate.LoadingStatePlaceholder
import com.sumera.puppyshelter.ui.components.styled.StyledLazyItem
import com.sumera.puppyshelter.ui.data.Breed
import com.sumera.puppyshelter.ui.data.Puppy
import com.sumera.puppyshelter.ui.data.generic.LoadingState

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PuppyListContent(
    state: LoadingState<List<Puppy>>,
    visibleBreeds: List<Breed>,
    onTryAgainClicked: () -> Unit,
    onPuppyClicked: (Puppy) -> Unit,
    lazyListState: LazyListState,
    topPadding: Dp,
    modifier: Modifier = Modifier,
    contentModifier: Modifier = Modifier,
) {
    val placeholderStatesPadding = if (state is LoadingState.Success) 0.dp else topPadding
    LoadingStatePlaceholder(
        state = state,
        onTryAgainClicked = onTryAgainClicked,
        modifier = modifier.padding(top = placeholderStatesPadding).fillMaxHeight(),
    ) { puppies ->
        LazyColumnWithPaddings(
            topPadding = topPadding,
            state = lazyListState,
            modifier = contentModifier
        ) {
            items(puppies) { puppy ->
                AnimatedVisibility(
                    visible = puppy.breed in visibleBreeds,
                    enter = expandVertically(),
                    exit = shrinkVertically(),
                ) {
                    StyledLazyItem {
                        PuppyCard(
                            name = puppy.name,
                            url = puppy.imageUrl,
                            distance = puppy.distanceKm,
                            age = puppy.ageWeeks,
                            onClicked = { onPuppyClicked(puppy) }
                        )
                    }
                }
            }
        }
    }
}
