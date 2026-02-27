package com.telefonica.apps.accessibility_catalog.view.screens.implementations.views.statedescriptions

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat
import com.telefonica.apps.accessibility_catalog.R
import com.telefonica.mistica.button.Button

class StateDescriptionsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : FrameLayout(context, attrs, defStyle) {

    private lateinit var soundModeButton: Button
    private lateinit var soundModeEmoji: TextView
    private var soundMode: SoundMode = SoundMode.SOUND

    init {
        LayoutInflater.from(context).inflate(R.layout.state_descriptions, this, true)
        setupThreeStateButton()
    }

    private fun setupThreeStateButton() {
        soundModeButton = findViewById(R.id.sound_mode_button)
        soundModeEmoji = findViewById(R.id.sound_mode_emoji)
        updateButtonState()

        soundModeButton.setOnClickListener {
            soundMode = soundMode.nextMode()
            updateButtonState()
        }
    }

    private fun updateButtonState() {
        val stateDesc = resources.getString(
            when (soundMode) {
                SoundMode.SOUND -> R.string.state_descriptions_implementation_sound_mode_enabled
                SoundMode.VIBRATION -> R.string.state_descriptions_implementation_vibration_mode_enabled
                SoundMode.SILENCE -> R.string.state_descriptions_implementation_silence_mode_enabled
            }
        )

        val emoji = when (soundMode) {
            SoundMode.SOUND -> "🔊"
            SoundMode.VIBRATION -> "📳"
            SoundMode.SILENCE -> "🔇"
        }

        val text = resources.getString(
            when (soundMode) {
                SoundMode.SOUND -> R.string.state_descriptions_implementation_change_to_vibration
                SoundMode.VIBRATION -> R.string.state_descriptions_implementation_change_to_silence
                SoundMode.SILENCE -> R.string.state_descriptions_implementation_change_to_sound
            }
        )

        soundModeEmoji.text = emoji
        soundModeButton.text = text
        ViewCompat.setStateDescription(soundModeButton, stateDesc)

        ViewCompat.replaceAccessibilityAction(
            soundModeButton,
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK,
            context.getString(R.string.state_descriptions_implementation_alternate_action),
            null
        )
    }

    private enum class SoundMode {
        SOUND,
        VIBRATION,
        SILENCE;

        fun nextMode(): SoundMode = when (this) {
            SOUND -> VIBRATION
            VIBRATION -> SILENCE
            SILENCE -> SOUND
        }
    }
}
