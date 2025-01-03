package com.telefonica.apps.accessibility_catalog.view.models

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import java.util.UUID

data class AccessibilityElement(
    val id: UUID,
    @StringRes val nameResId: Int,
    @StringRes val abstractResId: Int,
    val requirementsResId: List<Int> = emptyList(),
    val relatedLinksResId: List<TextLink> = emptyList(),
    val xmlViewImplementation: (@Composable () -> Unit)?,
    val composeImplementation: (@Composable () -> Unit)?,
)

data class DashboardElement(
    val id: UUID,
    @StringRes val nameResId: Int,
)

data class AccessibilityDetail(
    val id: UUID,
    @StringRes val nameResId: Int,
    @StringRes val abstractResId: Int,
    val requirementsResId: List<Int> = emptyList(),
    val relatedLinksResId: List<TextLink> = emptyList(),
)

data class AccessibilityImplementation(
    val xmlViewImplementation: (@Composable () -> Unit)?,
    val composeImplementation: (@Composable () -> Unit)?,
)

data class TextLink(
    @StringRes val url: Int,
    @StringRes val nameResId: Int,
)
