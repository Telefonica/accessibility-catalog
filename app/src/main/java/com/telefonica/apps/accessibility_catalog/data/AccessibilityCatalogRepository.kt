package com.telefonica.apps.accessibility_catalog.data

import com.telefonica.apps.accessibility_catalog.view.models.DashboardElement
import javax.inject.Inject

class AccessibilityCatalogRepository @Inject constructor(
    private val accessibilityDataSource: AccessibilityCatalogDataSource,
) {

    fun getDashboardElements(): List<DashboardElement> = accessibilityDataSource.getElements().map {
        DashboardElement(
            id = it.id,
            nameResId = it.nameResId,
        )
    }
}
