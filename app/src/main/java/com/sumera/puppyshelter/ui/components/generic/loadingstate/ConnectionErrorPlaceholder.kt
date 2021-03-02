package com.sumera.puppyshelter.ui.components.generic.loadingstate

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.sumera.puppyshelter.R

@Composable
fun ConnectionErrorPlaceholder(
    onTryAgainClicked: OnTryAgainClickListener,
    modifier: Modifier = Modifier,
    title: String = LocalContext.current.getString(R.string.connection_error_title),
    subtitle: String = LocalContext.current.getString(R.string.connection_error_subtitle),
) {
    ErrorPlaceholder(title, subtitle, onTryAgainClicked, modifier)
}

@Preview
@Composable
fun ConnectionErrorPlaceholderPreview() {
    ConnectionErrorPlaceholder({})
}
