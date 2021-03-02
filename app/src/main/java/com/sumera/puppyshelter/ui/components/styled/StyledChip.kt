package com.sumera.puppyshelter.ui.components.styled

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.sumera.puppyshelter.ui.modifiers.componentInnerHorizontalPaddingsSmall
import com.sumera.puppyshelter.ui.modifiers.componentInnerVerticalPaddingsSmall
import com.sumera.puppyshelter.ui.theme.base.DimensMaterialTheme

@Composable
fun StyledChip(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .clip(RoundedCornerShape(percent = 50))
            .clickable(onClick = { onClick() }),
        color = MaterialTheme.colors.primary
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .componentInnerVerticalPaddingsSmall()
                .componentInnerHorizontalPaddingsSmall()
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.body1.copy(
                    color = MaterialTheme.colors.onPrimary,
                    fontWeight = FontWeight.Medium
                )
            )
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Close",
                modifier = Modifier
                    .padding(start = DimensMaterialTheme.dimens.iconTextSpace)
                    .size(DimensMaterialTheme.dimens.smallIconSize)

            )
        }
    }
}

@Preview
@Composable
fun StyledChipPreview() {
    StyledChip(text = "Test", onClick = {})
}
