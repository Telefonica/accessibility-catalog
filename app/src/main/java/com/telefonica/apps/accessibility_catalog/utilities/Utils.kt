package com.telefonica.apps.accessibility_catalog.utilities

import android.content.Context
import kotlin.math.roundToInt

const val MIN_TOUCH_AREA_IN_DP = 48

fun Context.pixelsToDp(px: Float): Int {
    return (px / resources.displayMetrics.density).roundToInt()
}

fun Context.dpToPixels(dp: Int): Int {
    return (dp * resources.displayMetrics.density).roundToInt()
}
