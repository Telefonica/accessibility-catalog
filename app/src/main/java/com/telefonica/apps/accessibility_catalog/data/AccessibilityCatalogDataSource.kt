package com.telefonica.apps.accessibility_catalog.data

import com.telefonica.apps.accessibility_catalog.R
import com.telefonica.apps.accessibility_catalog.view.models.AccessibilityElement
import com.telefonica.apps.accessibility_catalog.view.models.TextLink
import com.telefonica.apps.accessibility_catalog.view.screens.common.AndroidViewImplementation
import com.telefonica.apps.accessibility_catalog.view.screens.common.ComposeImplementation
import com.telefonica.apps.accessibility_catalog.view.screens.implementations.compose.contentdescriptions.ContentDescriptionsCompose
import com.telefonica.apps.accessibility_catalog.view.screens.implementations.compose.headings.Headings
import com.telefonica.apps.accessibility_catalog.view.screens.implementations.compose.toggleables.ToggleablesCompose
import com.telefonica.apps.accessibility_catalog.view.screens.implementations.compose.touchtarget.TouchTarget
import com.telefonica.apps.accessibility_catalog.view.screens.implementations.views.contentdescriptions.ContentDescriptionsView
import com.telefonica.apps.accessibility_catalog.view.screens.implementations.views.headings.HeadingsView
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
                    nameResId = R.string.related_link_android_documentation
                ),
                TextLink(
                    url = R.string.touch_target_related_link_2,
                    nameResId = R.string.touch_target_related_link_2_name
                ),
                TextLink(
                    url = R.string.touch_target_related_link_3,
                    nameResId = R.string.related_link_magenta
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
            abstractResId = R.string.headings_abstract,
            requirementsResId = listOf(
                R.string.headings_requirement_section_principle,
                R.string.headings_requirement_avoid_in_list,
            ),
            relatedLinksResId = listOf(
                TextLink(
                    url = R.string.headings_related_link_1,
                    nameResId = R.string.related_link_android_documentation,
                ),
                TextLink(
                    url = R.string.headings_related_link_2,
                    nameResId = R.string.related_link_magenta,
                )
            ),
            xmlViewImplementation = {
                AndroidViewImplementation(
                    factory = { context ->
                        HeadingsView(context = context)
                    },
                    documentationUrl = R.string.headings_implementation_xml_documentation_url
                )
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
            abstractResId = R.string.toggleables_abstract,
            requirementsResId = listOf(
                R.string.toggleables_requirement_single_focus,
                R.string.toggleables_requirement_semantic_context,
            ),
            relatedLinksResId = listOf(
                TextLink(
                    url = R.string.toggleables_related_link_1,
                    nameResId = R.string.related_link_telefonica,
                ),
                TextLink(
                    url = R.string.toggleables_related_link_2,
                    nameResId = R.string.related_link_android_code_lab,
                ),
                TextLink(
                    url = R.string.toggleables_related_link_3,
                    nameResId = R.string.related_link_magenta,
                )
            ),
            xmlViewImplementation = {
                AndroidViewImplementation(
                    factory = { context ->
                        ToggleablesView(context = context)
                    },
                    documentationUrl = R.string.toggleables_implementation_xml_documentation_url
                )
            },
            composeImplementation = {
                ComposeImplementation(
                    composable = { ToggleablesCompose() },
                    documentationUrl = R.string.toggleables_implementation_compose_documentation_url
                )
            },
        ),
        //endregion

        //region Content Descriptions
        AccessibilityElement(
            id = UUID.randomUUID(),
            nameResId = R.string.content_descriptions_title_section,
            iconResId = R.drawable.ic_content_description,
            abstractResId = R.string.content_descriptions_abstract,
            requirementsResId = listOf(
                R.string.content_descriptions_requirement_meaningful_descriptions,
                R.string.content_descriptions_requirement_avoid_redundancy,
                R.string.content_descriptions_requirement_context_aware,
                R.string.content_descriptions_requirement_decorative_images,
            ),
            relatedLinksResId = listOf(
                TextLink(
                    url = R.string.content_descriptions_related_link_1,
                    nameResId = R.string.related_link_android_documentation,
                ),
                TextLink(
                    url = R.string.content_descriptions_related_link_2,
                    nameResId = R.string.related_link_magenta,
                ),
            ),
            xmlViewImplementation = {
                AndroidViewImplementation(
                    factory = { context ->
                        ContentDescriptionsView(context = context)
                    },
                    documentationUrl = R.string.content_descriptions_implementation_xml_documentation_url
                )
            },
            composeImplementation = {
                ComposeImplementation(
                    composable = { ContentDescriptionsCompose() },
                    documentationUrl = R.string.content_descriptions_implementation_compose_documentation_url
                )
            },
        ),
        //endregion
    )

    fun getElements() = accessibilityElements
}
