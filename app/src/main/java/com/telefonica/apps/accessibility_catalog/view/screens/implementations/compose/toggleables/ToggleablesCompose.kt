package com.telefonica.apps.accessibility_catalog.view.screens.implementations.compose.toggleables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.telefonica.apps.accessibility_catalog.R

@Composable
fun ToggleablesCompose() {

    var isSwitchChecked: Boolean by remember { mutableStateOf(false) }
    var isCheckBoxChecked by remember { mutableStateOf(false) }

    Column {
        CustomToggleable(
            trailingContent = { modifier ->
                Switch(
                    modifier = modifier,
                    checked = isSwitchChecked,
                    onCheckedChange = null
                )
            },
            role = Role.Switch,
            isChecked = isSwitchChecked,
            onToggle = { isSwitchChecked = !isSwitchChecked }
        )

        Spacer(Modifier.size(24.dp))

        CustomToggleable(
            trailingContent = { modifier ->
                Checkbox(
                    modifier = modifier,
                    checked = isCheckBoxChecked,
                    onCheckedChange = null
                )
            },
            role = Role.Checkbox,
            isChecked = isCheckBoxChecked,
            onToggle = { isCheckBoxChecked = !isCheckBoxChecked }
        )
    }
}

@Composable
private fun CustomToggleable(
    trailingContent: @Composable (Modifier) -> Unit,
    role: Role,
    isChecked: Boolean,
    onToggle: (Boolean) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .toggleable(
                value = isChecked,
                role = role,
                onValueChange = onToggle,
            ),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_ads_click_24),
            contentDescription = null,
        )

        Spacer(Modifier.size(12.dp))

        Column {
            Text(text = stringResource(R.string.toggleables_implementation_custom_title), fontSize = 18.sp, color = Color.Black)
            Spacer(Modifier.size(4.dp))
            Text(text = stringResource(R.string.toggleables_implementation_custom_subtitle), fontSize = 14.sp, color = Color.Gray)
        }

        Spacer(Modifier.weight(1f))

        trailingContent(Modifier.align(Alignment.CenterVertically))
    }
}
