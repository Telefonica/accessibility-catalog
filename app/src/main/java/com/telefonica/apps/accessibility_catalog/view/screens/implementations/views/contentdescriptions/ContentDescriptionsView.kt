package com.telefonica.apps.accessibility_catalog.view.screens.implementations.views.contentdescriptions

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.telefonica.apps.accessibility_catalog.R

class ContentDescriptionsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        orientation = VERTICAL
        LayoutInflater.from(context).inflate(R.layout.content_descriptions, this, true)
    }
}
