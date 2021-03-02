package com.sumera.puppyshelter.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sumera.puppyshelter.ui.theme.base.DimensMaterialTheme

@Composable
fun TextWithIcon(text: String, icon: ImageVector, modifier: Modifier = Modifier) {
    Row(modifier.wrapContentWidth()) {
        Text(
            text = text,
            style = MaterialTheme.typography.body2.copy(
                color = MaterialTheme.colors.onBackground,
                fontWeight = FontWeight.Medium
            )
        )
        Icon(icon, contentDescription = "Icon", modifier = modifier
            .padding(start = 4.dp)
            .size(DimensMaterialTheme.dimens.smallIconSize)
            .align(Alignment.CenterVertically)
        )
    }
}