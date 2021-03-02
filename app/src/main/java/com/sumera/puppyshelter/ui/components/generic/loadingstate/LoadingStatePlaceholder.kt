package com.sumera.puppyshelter.ui.components.generic.loadingstate

import androidx.compose.animation.Crossfade
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sumera.puppyshelter.tools.extensions.isConnectionError
import com.sumera.puppyshelter.ui.data.generic.LoadingState
import timber.log.Timber

@Composable
fun <DATA> LoadingStatePlaceholder(
    state: LoadingState<DATA>,
    onTryAgainClicked: OnTryAgainClickListener,
    modifier: Modifier = Modifier,
    loading: @Composable () -> Unit = { LoadingPlaceholder() },
    genericError: @Composable (OnTryAgainClickListener) -> Unit = { GenericErrorPlaceholder(onTryAgainClicked) },
    connectionError: @Composable (OnTryAgainClickListener) -> Unit = { ConnectionErrorPlaceholder(onTryAgainClicked) },
    content: @Composable (DATA) -> Unit,
) {
    Surface(color = MaterialTheme.colors.background) {
        Crossfade(targetState = state, modifier = modifier) { currentState ->
            when (currentState) {
                LoadingState.Loading -> loading()
                is LoadingState.Error -> if (currentState.error.isConnectionError) {
                    connectionError(onTryAgainClicked)
                } else {
                    genericError(onTryAgainClicked)
                }
                is LoadingState.Success -> {
                    content(currentState.data)
                }
            }
        }
    }
}

typealias OnTryAgainClickListener = () -> Unit

@Preview
@Composable
fun LoadingStatePlaceholderPreview() {
    LoadingStatePlaceholder(state = LoadingState.Loading, onTryAgainClicked = {}) {
        Text("Success")
    }
}
