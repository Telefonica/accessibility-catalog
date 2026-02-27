package com.telefonica.apps.accessibility_catalog.view.screens.implementations.compose.statedescriptions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    val emoji = when (soundMode) {
        SoundMode.SOUND -> "🔊"
        SoundMode.VIBRATION -> "📳"
        SoundMode.SILENCE -> "🔇"
    }

    val text = when (soundMode) {
        SoundMode.SOUND -> stringResource(R.string.state_descriptions_implementation_change_to_vibration)
        SoundMode.VIBRATION -> stringResource(R.string.state_descriptions_implementation_change_to_silence)
        SoundMode.SILENCE -> stringResource(R.string.state_descriptions_implementation_change_to_sound)
    }

    val changeAction = stringResource(R.string.state_descriptions_implementation_alternate_action)

    Spacer(modifier = Modifier.height(8.dp))


    Button(
        onClick = {
            soundMode = soundMode.nextMode()
        },
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .semantics {
                stateDescription = stateDesc
                contentDescription = text
                onClick(label = changeAction, action = null)
            }
    ) {
        Text(
            text = emoji,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(end = 8.dp)
                .semantics {
                    invisibleToUser()
                }
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

