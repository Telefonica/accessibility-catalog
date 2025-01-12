package com.telefonica.apps.accessibility_catalog.view.screens.implementations.compose.headings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.telefonica.mistica.compose.theme.MisticaTheme

@Composable
fun Headings() {
    Column {
        Text(
            modifier = Modifier.semantics { heading() },
            text = "One Heading",
            style = MisticaTheme.typography.presetTitle1,
            fontSize = 18.sp,
        )
        Spacer(Modifier.size(4.dp))
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            fontSize = 14.sp,
        )

        Spacer(Modifier.size(12.dp))

        Text(
            modifier = Modifier.semantics { heading() },
            text = "Another Heading",
            style = MisticaTheme.typography.presetTitle1,
            fontSize = 18.sp,
        )
        Spacer(Modifier.size(4.dp))
        Text(
            text = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",
            fontSize = 15.sp,
        )
    }
}
