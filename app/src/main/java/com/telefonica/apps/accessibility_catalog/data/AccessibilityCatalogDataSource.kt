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
import com.telefonica.apps.accessibility_catalog.view.models.TextLink
import com.telefonica.apps.accessibility_catalog.view.screens.common.AndroidViewImplementation
import com.telefonica.apps.accessibility_catalog.view.screens.common.ComposeImplementation
import com.telefonica.apps.accessibility_catalog.view.screens.implementations.compose.headings.Headings
import com.telefonica.apps.accessibility_catalog.view.screens.implementations.compose.touchtarget.TouchTarget
import com.telefonica.apps.accessibility_catalog.view.screens.implementations.views.toggleables.ToggleablesView
import com.telefonica.apps.accessibility_catalog.view.screens.implementations.views.touchtarget.TouchTargetView
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
            iconResId = R.drawable.ic_touch_target,
            abstractResId = R.string.touch_target_abstract,
            requirementsResId = listOf(
                R.string.touch_target_requirement_touch_target,
                R.string.touch_target_requirement_space_between,
                R.string.touch_target_requirement_custom_announcement,
            ),
            relatedLinksResId = listOf(
                TextLink(
                    url = R.string.touch_target_related_link_1,
                    nameResId = R.string.touch_target_related_link_1_name
                ),
                TextLink(
                    url = R.string.touch_target_related_link_2,
                    nameResId = R.string.touch_target_related_link_2_name
                ),
                TextLink(
                    url = R.string.touch_target_related_link_3,
                    nameResId = R.string.touch_target_related_link_3_name
                ),
            ),
            xmlViewImplementation = {
                AndroidViewImplementation(
                    factory = { context ->
                        TouchTargetView(context = context)
                    },
                    documentationUrl = R.string.touch_target_implementation_xml_documentation_url
                )
            },
            composeImplementation = {
                ComposeImplementation(
                    composable = { TouchTarget() },
                    documentationUrl = R.string.touch_target_implementation_compose_documentation_url
                )
            },
        ),
        //endregion

        //region Headings
        AccessibilityElement(
            id = UUID.randomUUID(),
            nameResId = R.string.headings_title_section,
            iconResId = R.drawable.ic_header,
            abstractResId = android.R.string.ok,
            xmlViewImplementation = {
                // todo
            },
            composeImplementation = {
                ComposeImplementation(
                    composable = { Headings() },
                    documentationUrl = R.string.headings_implementation_compose_documentation_url
                )
            },
        ),
        //endregion

        //region Toggleables
        AccessibilityElement(
            id = UUID.randomUUID(),
            nameResId = R.string.toggleables_title_section,
            iconResId = R.drawable.ic_toggleable,
            abstractResId = android.R.string.ok,
            xmlViewImplementation = {
                AndroidViewImplementation(factory = { context ->
                    ToggleablesView(context = context)
                })
            },
            composeImplementation = {
                // todo
            },
        ),
        //endregion
    )

    fun getElements() = accessibilityElements
}
