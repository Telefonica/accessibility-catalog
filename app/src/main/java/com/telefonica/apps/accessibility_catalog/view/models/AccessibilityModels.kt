package com.telefonica.apps.accessibility_catalog.view.models

import androidx.annotation.StringRes
import java.util.UUID

data class AccessibilityElement(
    val id: UUID,
    @StringRes val nameResId: Int,
    @StringRes val abstractResId: Int,
    val requirementsResId: List<Int> = emptyList(),
    val relatedLinksResId: List<RelatedLink> = emptyList(),
)

data class DashboardElement(
    val id: UUID,
    @StringRes val nameResId: Int,
)

data class RelatedLink(
    val url: String,
    @StringRes val nameResId: Int,
)
