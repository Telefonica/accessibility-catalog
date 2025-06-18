package com.telefonica.apps.accessibility_catalog.view.screens.implementations.views.touchtarget

import android.content.Context
import android.util.AttributeSet
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.chip.Chip
import com.telefonica.apps.accessibility_catalog.R
import com.telefonica.apps.accessibility_catalog.utilities.MIN_TOUCH_AREA_IN_DP
import com.telefonica.apps.accessibility_catalog.utilities.dpToPixels

class ButtonWrapperView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : FrameLayout(context, attrs, defStyle) {

    init {
        minimumHeight = context.dpToPixels(MIN_TOUCH_AREA_IN_DP)
        minimumWidth = context.dpToPixels(MIN_TOUCH_AREA_IN_DP)

        importantForAccessibility = IMPORTANT_FOR_ACCESSIBILITY_YES

        setOnClickListener {
            Toast.makeText(context, context.getString(R.string.touch_target_implementation_feedback_clicked), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onInitializeAccessibilityEvent(event: AccessibilityEvent?) {
        super.onInitializeAccessibilityEvent(event)
        event?.className = Button::class.java.name
    }

    override fun onInitializeAccessibilityNodeInfo(info: AccessibilityNodeInfo?) {
        super.onInitializeAccessibilityNodeInfo(info)
        info?.className = Button::class.java.name
    }
}

class ChipWrapperView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : FrameLayout(context, attrs, defStyle) {

    init {
        minimumHeight = context.dpToPixels(MIN_TOUCH_AREA_IN_DP)
        minimumWidth = context.dpToPixels(MIN_TOUCH_AREA_IN_DP)

        importantForAccessibility = IMPORTANT_FOR_ACCESSIBILITY_YES

        setOnClickListener {
            Toast.makeText(context, context.getString(R.string.touch_target_implementation_feedback_clicked), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onInitializeAccessibilityEvent(event: AccessibilityEvent?) {
        super.onInitializeAccessibilityEvent(event)
        event?.className = Chip::class.java.name
    }

    override fun onInitializeAccessibilityNodeInfo(info: AccessibilityNodeInfo?) {
        super.onInitializeAccessibilityNodeInfo(info)
        info?.className = Chip::class.java.name
    }
}

class ImageWrapperView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : FrameLayout(context, attrs, defStyle) {

    init {
        minimumHeight = context.dpToPixels(MIN_TOUCH_AREA_IN_DP)
        minimumWidth = context.dpToPixels(MIN_TOUCH_AREA_IN_DP)

        importantForAccessibility = IMPORTANT_FOR_ACCESSIBILITY_YES

        setOnClickListener {
            Toast.makeText(context, context.getString(R.string.touch_target_implementation_feedback_clicked), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onInitializeAccessibilityEvent(event: AccessibilityEvent?) {
        super.onInitializeAccessibilityEvent(event)
        event?.className = ImageView::class.java.name
    }

    override fun onInitializeAccessibilityNodeInfo(info: AccessibilityNodeInfo?) {
        super.onInitializeAccessibilityNodeInfo(info)
        info?.className = ImageView::class.java.name
    }
}
