package com.telefonica.apps.accessibility_catalog.view.screens.implementations.views.headings

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.ViewCompat
import com.telefonica.apps.accessibility_catalog.R

class HeadingsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : FrameLayout(context, attrs, defStyle) {

    init {
        LayoutInflater.from(context).inflate(R.layout.headings, this, true)

        val headingOne = findViewById<TextView>(R.id.heading_one)
        ViewCompat.setAccessibilityHeading(headingOne, true)

        val headingTwo = findViewById<TextView>(R.id.heading_two)
        ViewCompat.setAccessibilityHeading(headingTwo, true)
    }
}
