package com.telefonica.apps.accessibility_catalog.view.screens.implementations.compose.statedescriptions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.unit.dp
import com.telefonica.apps.accessibility_catalog.R
import com.telefonica.apps.accessibility_catalog.view.screens.implementations.compose.statedescriptions.SoundMode.Companion.nextMode
import com.telefonica.mistica.compose.title.Title
import com.telefonica.mistica.compose.title.TitleStyle

@Composable
fun StateDescriptions() {
    Column {
        ExampleWithThreeStateButton()
    }
}

@Composable
private fun ColumnScope.ExampleWithThreeStateButton() {
    Title(
        style = TitleStyle.TITLE_1,
        text = stringResource(R.string.state_descriptions_implementation_three_state_button_title),
    )

    var soundMode by remember { mutableStateOf(SoundMode.SOUND) }

    val stateDesc = when (soundMode) {
        SoundMode.SOUND -> stringResource(R.string.state_descriptions_implementation_sound_mode_enabled)
        SoundMode.VIBRATION -> stringResource(R.string.state_descriptions_implementation_vibration_mode_enabled)
        SoundMode.SILENCE -> stringResource(R.string.state_descriptions_implementation_silence_mode_enabled)
    }

    val iconRes = when (soundMode) {
        SoundMode.SOUND -> R.drawable.ic_volume_active
        SoundMode.VIBRATION -> R.drawable.ic_volume_vibrate
        SoundMode.SILENCE -> R.drawable.ic_volume_mute
    }

    val contentDesc =
        when (soundMode) {
            SoundMode.SOUND -> stringResource(R.string.state_descriptions_implementation_change_to_vibration)
            SoundMode.VIBRATION -> stringResource(R.string.state_descriptions_implementation_change_to_silence)
            SoundMode.SILENCE -> stringResource(R.string.state_descriptions_implementation_change_to_sound)
        }

    val changeAction = stringResource(R.string.state_descriptions_implementation_alternate_action)

    Spacer(modifier = Modifier.height(8.dp))

    IconButton(
        onClick = {
            soundMode = soundMode.nextMode()
        },
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .size(48.dp)
            .semantics {
                stateDescription = stateDesc
                onClick(label = changeAction, action = null)
            }
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = contentDesc
        )
    }
}

enum class SoundMode() {
    SOUND,
    VIBRATION,
    SILENCE;

    companion object {
        fun SoundMode.nextMode(): SoundMode =
            when (this) {
                SOUND -> VIBRATION
                VIBRATION -> SILENCE
                SILENCE -> SOUND
            }
    }
}

