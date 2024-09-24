package com.telefonica.apps.accessibility_catalog.data

import com.telefonica.apps.accessibility_catalog.R
import com.telefonica.apps.accessibility_catalog.view.models.AccessibilityElement
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AccessibilityCatalogDataSource @Inject constructor() {

    private val accessibilityElements = listOf(
        AccessibilityElement(
            id = UUID.randomUUID(),
            nameResId = R.string.touch_target_title_section,
            abstractResId = R.string.touch_target_abstract
        ),
        AccessibilityElement(
            id = UUID.randomUUID(),
            nameResId = R.string.headings_title_section,
            abstractResId = android.R.string.ok,
        ),
    )

    fun getElements() = accessibilityElements
}
