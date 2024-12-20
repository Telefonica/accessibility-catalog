package com.telefonica.apps.accessibility_catalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.telefonica.apps.accessibility_catalog.ui.theme.AccessibilityCatalogTheme
import com.telefonica.apps.accessibility_catalog.view.navigation.AccessibilityCatalogNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            AccessibilityCatalogTheme {
                AccessibilityCatalogNavHost()
            }
        }
    }
}
