package com.telefonica.apps.accessibility_catalog.view.screens.implementations.views.toggleables

import android.content.Context
import android.util.AttributeSet
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat
import com.telefonica.apps.accessibility_catalog.R

class SwitchCustomComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : ConstraintLayout(context, attrs, defStyle) {

    private lateinit var titleView: TextView
    private lateinit var subtitleView: TextView
    private lateinit var switchView: SwitchCompat

    override fun onFinishInflate() {
        super.onFinishInflate()

        titleView = findViewById(R.id.custom_switch_title)
        subtitleView = findViewById(R.id.custom_switch_subtitle)
        switchView = findViewById(R.id.custom_toggleable_switch)

        initAccessibilityConfiguration()
    }

    private fun initAccessibilityConfiguration() {
        contentDescription = "${titleView.text}. ${subtitleView.text}"
        ViewCompat.setStateDescription(this@SwitchCustomComponent, ViewCompat.getStateDescription(switchView))
    }

    fun changeSwitchState(enable: Boolean? = null) {
        switchView.isChecked = enable ?: !switchView.isChecked
        ViewCompat.setStateDescription(this@SwitchCustomComponent, ViewCompat.getStateDescription(switchView))
    }

    fun getSwitchState() = switchView.isChecked

    override fun onInitializeAccessibilityEvent(event: AccessibilityEvent?) {
        super.onInitializeAccessibilityEvent(event)
        event?.className = Switch::class.java.name
    }

    override fun onInitializeAccessibilityNodeInfo(info: AccessibilityNodeInfo?) {
        super.onInitializeAccessibilityNodeInfo(info)
        info?.className = Switch::class.java.name
        info?.addAction(
            AccessibilityNodeInfo.AccessibilityAction(
                AccessibilityNodeInfoCompat.ACTION_CLICK,
                context.getString(R.string.accessibility_switch_toggle_action)
            )
        )
    }
}
