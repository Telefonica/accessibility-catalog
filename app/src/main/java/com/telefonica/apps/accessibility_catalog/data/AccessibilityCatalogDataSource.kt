package com.telefonica.apps.accessibility_catalog.data

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.telefonica.apps.accessibility_catalog.R
import com.telefonica.apps.accessibility_catalog.view.models.AccessibilityElement
import com.telefonica.apps.accessibility_catalog.view.models.RelatedLink
import com.telefonica.apps.accessibility_catalog.view.screens.common.AndroidViewImplementation
import com.telefonica.apps.accessibility_catalog.view.screens.implementations.views.toggleables.ToggleablesView
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AccessibilityCatalogDataSource @Inject constructor() {

    private val accessibilityElements = listOf(
        //region Clickable areas
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
            ),
            xmlViewImplementation = null, // todo
            composeImplementation = {
                // todo
            },
        ),
        //endregion

        //region Headings
        AccessibilityElement(
            id = UUID.randomUUID(),
            nameResId = R.string.headings_title_section,
            abstractResId = android.R.string.ok,
            xmlViewImplementation = {
                // todo
            },
            composeImplementation = {
                // todo
            },
        ),
        //endregion

        //region Toggleables
        AccessibilityElement(
            id = UUID.randomUUID(),
            nameResId = R.string.toggleables_title_section,
            abstractResId = android.R.string.ok,
            xmlViewImplementation = {
                AndroidViewImplementation(factory = { context ->
                    ToggleablesView(context = context)
                })
            },
            composeImplementation = {
                // todo
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(Color.Blue)
                )
            },
        ),
        //endregion
    )

    fun getElements() = accessibilityElements
}
