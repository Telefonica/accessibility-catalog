package com.telefonica.apps.accessibility_catalog.view.screens.implementations.views.statedescriptions

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.widget.SwitchCompat
import androidx.core.view.ViewCompat
import com.telefonica.apps.accessibility_catalog.R

class StateDescriptionsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : FrameLayout(context, attrs, defStyle) {

    private val notificationToggleContainer: LinearLayout
    private val notificationSwitch: SwitchCompat

    init {
        LayoutInflater.from(context).inflate(R.layout.state_descriptions, this, true)

        notificationToggleContainer = findViewById(R.id.notification_toggle_container)
        notificationSwitch = findViewById(R.id.notification_switch)

        setupToggle()
    }

    private fun setupToggle() {
        updateStateDescription(notificationSwitch.isChecked)

        notificationToggleContainer.setOnClickListener {
            notificationSwitch.toggle()
            updateStateDescription(notificationSwitch.isChecked)
        }
    }

    private fun updateStateDescription(isEnabled: Boolean) {
        val stateDescription = if (isEnabled) {
            "Recibirás notificaciones push"
        } else {
            "No recibirás notificaciones push"
        }
        ViewCompat.setStateDescription(notificationToggleContainer, stateDescription)
    }
}
