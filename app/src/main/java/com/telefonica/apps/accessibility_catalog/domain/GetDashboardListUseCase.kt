package com.telefonica.apps.accessibility_catalog.domain

import com.telefonica.apps.accessibility_catalog.data.AccessibilityCatalogRepository
import com.telefonica.apps.accessibility_catalog.view.models.DashboardElement
import javax.inject.Inject

class GetDashboardListUseCase @Inject constructor(
    private val accessibilityCatalogRepository: AccessibilityCatalogRepository,
) {
    operator fun invoke(): List<DashboardElement> = accessibilityCatalogRepository.getDashboardElements()
}
