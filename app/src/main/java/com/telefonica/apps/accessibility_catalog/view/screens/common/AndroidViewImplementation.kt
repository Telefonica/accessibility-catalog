package com.telefonica.apps.accessibility_catalog.view.screens.common

import android.content.Context
import android.view.View
import androidx.annotation.StringRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.telefonica.apps.accessibility_catalog.R
import com.telefonica.apps.accessibility_catalog.utilities.TextWithLink
import com.telefonica.apps.accessibility_catalog.view.models.TextLink

@Composable
fun <T : View> AndroidViewImplementation(
    modifier: Modifier = Modifier,
    factory: (Context) -> T,
    @StringRes documentationUrl: Int? = null,
) {
    Column {
        AndroidView(
            modifier = modifier
                .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(12.dp))
                .fillMaxWidth()
                .padding(all = 12.dp),
            factory = factory,
        )
        if (documentationUrl != null) {
            Spacer(Modifier.size(4.dp))
            TextWithLink(textLink = TextLink(documentationUrl, R.string.implementation_see_documentation))
        }
    }
}

@Composable
fun ComposeImplementation(
    modifier: Modifier = Modifier,
    composable: @Composable () -> Unit,
    @StringRes documentationUrl: Int? = null,
) {
    Column {
        Box(
            modifier = modifier
                .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(12.dp))
                .fillMaxWidth()
                .padding(all = 12.dp),
        ) {
            composable()
        }
        if (documentationUrl != null) {
            Spacer(Modifier.size(4.dp))
            TextWithLink(textLink = TextLink(documentationUrl, R.string.implementation_see_documentation))
        }
    }
}
