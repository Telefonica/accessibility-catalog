package com.telefonica.apps.accessibility_catalog.view.screens.implementations.views.statedescriptions

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.telefonica.apps.accessibility_catalog.R

class StateDescriptionsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : FrameLayout(context, attrs, defStyle) {


    init {
        LayoutInflater.from(context).inflate(R.layout.state_descriptions, this, true)
    }

}
