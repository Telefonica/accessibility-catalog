package com.telefonica.apps.accessibility_catalog.data

import com.telefonica.apps.accessibility_catalog.view.models.AccessibilityDetail
import com.telefonica.apps.accessibility_catalog.view.models.AccessibilityElement
import com.telefonica.apps.accessibility_catalog.view.models.AccessibilityImplementation
import com.telefonica.apps.accessibility_catalog.view.models.DashboardElement
import java.util.UUID
import javax.inject.Inject

class AccessibilityCatalogRepository @Inject constructor(
    private val accessibilityDataSource: AccessibilityCatalogDataSource,
) {

    fun getDashboardElements(): List<DashboardElement> = accessibilityDataSource.getElements()
        .map {
            DashboardElement(
                id = it.id,
                nameResId = it.nameResId,
                iconResId = it.iconResId,
            )
        }

    fun getAccessibilityDetail(elementId: UUID): AccessibilityDetail? = accessibilityDataSource.getElements()
        .filter { it.id == elementId }
        .map {
            AccessibilityDetail(
                id = it.id,
                nameResId = it.nameResId,
                abstractResId = it.abstractResId,
                requirementsResId = it.requirementsResId,
                relatedLinksResId = it.relatedLinksResId,
            )
        }
        .firstOrNull()

    fun getAccessibilityImplementation(elementId: UUID) : AccessibilityImplementation?  = accessibilityDataSource.getElements()
        .filter { it.id == elementId }
        .map {
            AccessibilityImplementation(
                xmlViewImplementation = it.xmlViewImplementation,
                composeImplementation = it.composeImplementation,
            )
        }.firstOrNull()

}
