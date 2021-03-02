package com.sumera.puppyshelter.ui.screens.puppylist.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sumera.puppyshelter.ui.components.NetworkImage
import com.sumera.puppyshelter.ui.components.TextWithIcon
import com.sumera.puppyshelter.ui.components.styled.StyledCard
import com.sumera.puppyshelter.ui.modifiers.componentInnerPaddings

@Composable
fun PuppyCard(
    name: String,
    distance: Float,
    age: Int,
    url: String,
    onClicked: () -> Unit
) {
    StyledCard(
        onClicked = onClicked
    ) {
        Column {
            NetworkImage(
                url = url,
                contentDescription = "Puppy $name",
                backgroundColor = MaterialTheme.colors.background,
                modifier = Modifier.fillMaxWidth().height(180.dp)
            )
            Box(modifier = Modifier.fillMaxWidth().componentInnerPaddings()) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.h6.copy(
                        color = MaterialTheme.colors.onBackground,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier.fillMaxHeight()
                )
                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    TextWithIcon("$distance km", Icons.Filled.LocationOn)
                    Text(
                        text = "Weeks: $age",
                        style = MaterialTheme.typography.body2.copy(
                            color = MaterialTheme.colors.onBackground,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }

            }
        }

    }
}

@Preview
@Composable
fun PuppyCardPreview() {
    PuppyCard(
        name = "Puppy",
        url = "www.image.com",
        distance = 1.2f,
        age = 20,
        onClicked = {},
    )
}