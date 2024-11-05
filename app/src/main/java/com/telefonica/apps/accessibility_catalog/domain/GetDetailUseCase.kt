package com.telefonica.apps.accessibility_catalog.domain

import com.telefonica.apps.accessibility_catalog.data.AccessibilityCatalogRepository
import com.telefonica.apps.accessibility_catalog.view.models.AccessibilityDetail
import java.util.UUID
import javax.inject.Inject

class GetDetailUseCase @Inject constructor(
    private val accessibilityCatalogRepository: AccessibilityCatalogRepository,
) {

    operator fun invoke(elementId: UUID) : AccessibilityDetail? = accessibilityCatalogRepository.getAccessibilityDetail(elementId)
}
