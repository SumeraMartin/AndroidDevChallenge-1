package com.sumera.puppyshelter.ui.components.generic.loadingstate

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ErrorPlaceholder(
    title: String,
    subtitle: String,
    onTryAgainClicked: OnTryAgainClickListener,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Column {
            Text(title)
            Text(subtitle)
            Button(
                onClick = { onTryAgainClicked() }
            ) {
                Text("Try again")
            }
        }
    }
}

@Preview
@Composable
fun ErrorPreview() {
    ErrorPlaceholder(
        title = "Title",
        subtitle = "Subtitle",
        onTryAgainClicked = {}
    )
}
