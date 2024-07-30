package com.telefonica.apps.accessibility_catalog.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.telefonica.apps.accessibility_catalog.R
import com.telefonica.mistica.compose.list.ListRowIcon
import com.telefonica.mistica.compose.list.ListRowItem
import com.telefonica.mistica.compose.theme.MisticaTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Dashboard(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Box(modifier = Modifier.background(MisticaTheme.colors.brandLow)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
            ) {
                Image(
                    modifier = Modifier
                        .height(45.dp)
                        .background(Color.Red),
                    painter = painterResource(id = R.drawable.ic_dashboard_logo),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    text = "Accessibility catalog",
                    style = MisticaTheme.typography.presetTitle1.copy(lineHeight = TextUnit.Unspecified),
                    fontSize = 32.sp,
                )
            }
        }
        Spacer(modifier = Modifier.size(8.dp))
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            ListRowItem(
                listRowIcon = ListRowIcon.NormalIcon(
                    painter = painterResource(id = R.drawable.ic_buttons),
                    tint = Color.Unspecified,
                ),
                title = "Actions",
            )
        }
    }
}
