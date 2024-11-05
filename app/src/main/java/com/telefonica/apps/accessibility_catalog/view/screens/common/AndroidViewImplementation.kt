package com.telefonica.apps.accessibility_catalog.view.screens.common

import android.content.Context
import android.view.View
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun <T : View> AndroidViewImplementation(
    modifier: Modifier = Modifier,
    factory: (Context) -> T,
) {
    AndroidView(
        modifier = modifier
            .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .padding(all = 12.dp),
        factory = factory,
    )
}
