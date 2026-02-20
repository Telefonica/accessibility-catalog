package com.telefonica.apps.accessibility_catalog.view.screens.implementations.compose.statedescriptions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.telefonica.mistica.compose.title.Title
import com.telefonica.mistica.compose.title.TitleStyle

@Composable
fun StateDescriptions() {
    Column {
        ExampleWithToggle()
    }
}

@Composable
private fun ExampleWithToggle() {
    Title(
        style = TitleStyle.TITLE_1,
        text = "Example with toggle",
    )

    var isEnabled by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .toggleable(
                value = isEnabled,
                role = Role.Switch,
                onValueChange = { isEnabled = !isEnabled }
            )
            .semantics {
                stateDescription = if (isEnabled) {
                    "Recibirás notificaciones push"
                } else {
                    "No recibirás notificaciones push"
                }
            }
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Notificaciones",
            fontSize = 16.sp,
            modifier = Modifier.weight(1f)
        )
        Switch(
            checked = isEnabled,
            onCheckedChange = null
        )
    }
}
