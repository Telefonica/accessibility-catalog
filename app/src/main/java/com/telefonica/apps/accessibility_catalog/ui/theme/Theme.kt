package com.telefonica.apps.accessibility_catalog.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import com.telefonica.mistica.compose.theme.MisticaTheme
import com.telefonica.mistica.compose.theme.brand.Brand
import com.telefonica.mistica.compose.theme.brand.TelefonicaBrand

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AccessibilityCatalogTheme(
    brand: Brand = TelefonicaBrand,
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {

    MisticaTheme(
        brand = brand,
        darkTheme = darkTheme,
    ) {
        Surface(
            modifier = Modifier.semantics {
                testTagsAsResourceId = true
            },
            color = MisticaTheme.colors.background,
        ) {
            content()
        }
    }
}
