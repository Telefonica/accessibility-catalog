package com.telefonica.apps.accessibility_catalog.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.telefonica.apps.accessibility_catalog.R
import com.telefonica.mistica.compose.theme.MisticaTheme

@Composable
fun Dashboard(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Row {
            Image(
                modifier = Modifier
                    .padding(8.dp)
                    .size(width = 100.dp, height = 50.dp),
                painter = painterResource(id = R.drawable.ic_dashboard_main),
                contentDescription = null
            )
            Text(
                text = "Accessibility catalog",
                style = MisticaTheme.typography.presetTitle1,
                fontSize = 36.sp
            )
        }

    }
}

