package com.telefonica.apps.accessibility_catalog.view.screens.implementations.views.touchtarget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.chip.Chip
import com.telefonica.apps.accessibility_catalog.R

class TouchTargetView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : FrameLayout(context, attrs, defStyle) {

    init {
        LayoutInflater.from(context).inflate(R.layout.touch_target_size, this, true)

        //region Using Touch Delegate
        findViewById<Button>(R.id.touch_delegate_small_button).apply {
            implementOnClickFeedback()
            ensureMinimalTouchTarget()
        }

        findViewById<Chip>(R.id.touch_delegate_small_chip).apply {
            implementOnClickFeedback()
            ensureMinimalTouchTarget()
        }

        findViewById<ImageView>(R.id.touch_delegate_small_icon_button).apply {
            implementOnClickFeedback()
            ensureMinimalTouchTarget()
        }
        //endregion

        //region Custom action announcement
        findViewById<Button>(R.id.custom_announcement_button).apply {
            implementOnClickFeedback()
            setCustomAnnouncementTap(context.getString(R.string.touch_target_implementation_send_button_action))
        }

        findViewById<Chip>(R.id.custom_announcement_chip).apply {
            implementOnClickFeedback()
            setCustomAnnouncementTap(context.getString(R.string.touch_target_implementation_filter_chip_action))
        }

        findViewById<ImageView>(R.id.custom_announcement_icon_button).apply {
            implementOnClickFeedback()
            setCustomAnnouncementTap(context.getString(R.string.touch_target_implementation_filter_image_button_action))
        }
        //endregion
    }

    private fun View.implementOnClickFeedback() {
        setOnClickListener { Toast.makeText(context, context.getString(R.string.touch_target_implementation_feedback_clicked), Toast.LENGTH_SHORT).show() }
    }
}
