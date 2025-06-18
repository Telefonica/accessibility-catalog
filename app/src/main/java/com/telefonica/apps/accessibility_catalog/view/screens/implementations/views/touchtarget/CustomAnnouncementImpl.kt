package com.telefonica.apps.accessibility_catalog.view.screens.implementations.views.touchtarget

import android.view.View
import android.view.accessibility.AccessibilityNodeInfo
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat

fun View.setCustomAnnouncementTap(actionClickAnnouncement: String) {

    accessibilityDelegate = object : View.AccessibilityDelegate() {
        override fun onInitializeAccessibilityNodeInfo(host: View, info: AccessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(host, info)
            info.addAction(
                AccessibilityNodeInfo.AccessibilityAction(
                    AccessibilityNodeInfoCompat.ACTION_CLICK,
                    actionClickAnnouncement
                )
            )
        }
    }
}
