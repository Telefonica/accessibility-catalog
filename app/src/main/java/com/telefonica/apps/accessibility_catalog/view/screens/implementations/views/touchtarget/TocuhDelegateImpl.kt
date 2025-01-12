package com.telefonica.apps.accessibility_catalog.view.screens.implementations.views.touchtarget

import android.graphics.Rect
import android.view.TouchDelegate
import android.view.View
import com.telefonica.apps.accessibility_catalog.utilities.MIN_TOUCH_AREA_IN_DP
import com.telefonica.apps.accessibility_catalog.utilities.dpToPixels
import com.telefonica.apps.accessibility_catalog.utilities.pixelsToDp

internal fun View.ensureMinimalTouchTarget() {
    val parent = parent as View
    parent.post {
        val bounds = Rect()
        getHitRect(bounds)

        // Check vertical size
        val heightInDps = context.pixelsToDp(height.toFloat())
        val verticalTouchAreaExpansionNeeded = MIN_TOUCH_AREA_IN_DP - heightInDps
        if (verticalTouchAreaExpansionNeeded > 0) {
            bounds.top -= context.dpToPixels(verticalTouchAreaExpansionNeeded / 2)
            bounds.bottom += context.dpToPixels(verticalTouchAreaExpansionNeeded / 2)
        }

        // Check horizontal size
        val widthInDps = context.pixelsToDp(width.toFloat())
        val horizontalTouchAreaExpansionNeeded = MIN_TOUCH_AREA_IN_DP - widthInDps
        if (horizontalTouchAreaExpansionNeeded > 0) {
            bounds.left -= context.dpToPixels(horizontalTouchAreaExpansionNeeded / 2)
            bounds.right += context.dpToPixels(horizontalTouchAreaExpansionNeeded / 2)
        }

        // Update touchable area
        parent.touchDelegate = TouchDelegate(bounds, this)
    }
}
