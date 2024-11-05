package com.telefonica.apps.accessibility_catalog.domain

import com.telefonica.apps.accessibility_catalog.data.AccessibilityCatalogRepository
import com.telefonica.apps.accessibility_catalog.view.models.AccessibilityImplementation
import java.util.UUID
import javax.inject.Inject

class GetImplementationUseCase @Inject constructor(
    private val accessibilityCatalogRepository: AccessibilityCatalogRepository,
) {

    operator fun invoke(elementId: UUID) : AccessibilityImplementation? = accessibilityCatalogRepository.getAccessibilityImplementation(elementId)
}