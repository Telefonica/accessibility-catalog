package com.telefonica.apps.accessibility_catalog.view.screens.implementations.views.toggleables

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.telefonica.apps.accessibility_catalog.R

class ToggleablesView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : FrameLayout(context, attrs, defStyle) {

    init {
        LayoutInflater.from(context).inflate(R.layout.toggleables, this, true)

        val switchCustomComponent: SwitchCustomComponent = findViewById(R.id.switch_custom_component_root_layout)
        switchCustomComponent.setOnClickListener {
            switchCustomComponent.changeSwitchState()
        }

        val checkBoxCustomComponent: CheckBoxCustomComponent = findViewById(R.id.checkbox_custom_component_root_layout)
        checkBoxCustomComponent.setOnClickListener {
            checkBoxCustomComponent.changeCheckBoxState()
        }
    }
}
