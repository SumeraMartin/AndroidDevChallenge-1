package com.sumera.puppyshelter.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun NetworkImage(
    url: String,
    contentDescription: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
) {
    CoilImage(
        data = url,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        loading = {
            Surface(color = backgroundColor, modifier = Modifier.fillMaxSize()) { }
        },
        error = {
            Surface(color = backgroundColor, modifier = Modifier.fillMaxSize()) { }
        },
        modifier = modifier,
    )
}
