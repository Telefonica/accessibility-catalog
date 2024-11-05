package com.telefonica.apps.accessibility_catalog.data

import com.telefonica.apps.accessibility_catalog.R
import com.telefonica.apps.accessibility_catalog.view.models.AccessibilityElement
import com.telefonica.apps.accessibility_catalog.view.models.RelatedLink
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AccessibilityCatalogDataSource @Inject constructor() {

    private val accessibilityElements = listOf(
        AccessibilityElement(
            id = UUID.randomUUID(),
            nameResId = R.string.touch_target_title_section,
            abstractResId = R.string.touch_target_abstract,
            requirementsResId = listOf(
                R.string.touch_target_requirement_touch_target,
                R.string.touch_target_requirement_space_between,
                R.string.touch_target_requirement_custom_announcement,
            ),
            relatedLinksResId = listOf(
                RelatedLink(
                    url = R.string.touch_target_related_link_1,
                    nameResId = R.string.touch_target_related_link_1_name
                ),
                RelatedLink(
                    url = R.string.touch_target_related_link_2,
                    nameResId = R.string.touch_target_related_link_2_name
                ),
                RelatedLink(
                    url = R.string.touch_target_related_link_3,
                    nameResId = R.string.touch_target_related_link_3_name
                ),
            )
        ),
        AccessibilityElement(
            id = UUID.randomUUID(),
            nameResId = R.string.headings_title_section,
            abstractResId = android.R.string.ok,
        ),
        AccessibilityElement(
            id = UUID.randomUUID(),
            nameResId = R.string.toggleables_title_section,
            abstractResId = android.R.string.ok,
        ),
    )

    fun getElements() = accessibilityElements
}
