package com.telefonica.apps.accessibility_catalog.view.screens.implementations.views.toggleables

import android.content.Context
import android.util.AttributeSet
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat
import com.telefonica.apps.accessibility_catalog.R

class CheckBoxCustomComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : ConstraintLayout(context, attrs, defStyle) {

    private lateinit var titleView: TextView
    private lateinit var subtitleView: TextView
    private lateinit var checkBoxView: AppCompatCheckBox

    override fun onFinishInflate() {
        super.onFinishInflate()

        titleView = findViewById(R.id.custom_checkbox_title)
        subtitleView = findViewById(R.id.custom_checkbox_subtitle)
        checkBoxView = findViewById(R.id.custom_toggleable_checkbox)

        initAccessibilityConfiguration()
    }

    private fun initAccessibilityConfiguration() {
        contentDescription = "${titleView.text}. ${subtitleView.text}"
        ViewCompat.setStateDescription(this@CheckBoxCustomComponent, ViewCompat.getStateDescription(checkBoxView))
    }

    fun changeCheckBoxState(enable: Boolean? = null) {
        checkBoxView.isChecked = enable ?: !checkBoxView.isChecked
        ViewCompat.setStateDescription(this@CheckBoxCustomComponent, ViewCompat.getStateDescription(checkBoxView))
    }

    fun getCheckBoxState() = checkBoxView.isChecked

    override fun onInitializeAccessibilityEvent(event: AccessibilityEvent?) {
        super.onInitializeAccessibilityEvent(event)
        event?.className = CheckBox::class.java.name
    }

    override fun onInitializeAccessibilityNodeInfo(info: AccessibilityNodeInfo?) {
        super.onInitializeAccessibilityNodeInfo(info)
        info?.className = CheckBox::class.java.name
        info?.addAction(
            AccessibilityNodeInfo.AccessibilityAction(
                AccessibilityNodeInfoCompat.ACTION_CLICK,
                if (checkBoxView.isChecked)
                    context.getString(R.string.accessibility_checkbox_turn_off_action)
                else
                    context.getString(R.string.accessibility_checkbox_turn_on_action)
            )
        )
    }
}
