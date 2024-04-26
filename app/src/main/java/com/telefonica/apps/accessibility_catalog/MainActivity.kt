package com.telefonica.apps.accessibility_catalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.telefonica.apps.accessibility_catalog.ui.theme.AccessibilityCatalogTheme
import com.telefonica.mistica.button2.Button
import com.telefonica.mistica.compose.theme.MisticaTheme
import com.telefonica.mistica.compose.theme.brand.TelefonicaBrand

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AccessibilityCatalogTheme {
                
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AccessibilityCatalogTheme {

    }
}