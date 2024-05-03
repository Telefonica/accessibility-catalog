package com.telefonica.apps.accessibility_catalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.telefonica.apps.accessibility_catalog.navigation.AccessibilityCatalogNavHost
import com.telefonica.apps.accessibility_catalog.ui.theme.AccessibilityCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AccessibilityCatalogTheme {
                AccessibilityCatalogNavHost()
            }
        }
    }
}
