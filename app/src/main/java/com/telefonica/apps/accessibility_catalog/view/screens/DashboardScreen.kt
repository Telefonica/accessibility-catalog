package com.telefonica.apps.accessibility_catalog.view.screens

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
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.telefonica.apps.accessibility_catalog.R
import com.telefonica.apps.accessibility_catalog.view.viewmodels.DashboardViewModel
import com.telefonica.mistica.compose.list.ListRowIcon
import com.telefonica.mistica.compose.list.ListRowItem
import com.telefonica.mistica.compose.shape.Chevron
import com.telefonica.mistica.compose.theme.MisticaTheme
import java.util.UUID

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    viewModel: DashboardViewModel = hiltViewModel(),
    navigateToDetail: (elementId: UUID) -> Unit,
) {

    val dashboardState by viewModel.state.collectAsState()

    Column(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .background(MisticaTheme.colors.brandLow)
                .safeDrawingPadding()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                Image(
                    modifier = Modifier
                        .height(35.dp)
                        .background(Color.Red),
                    painter = painterResource(id = R.drawable.ic_dashboard_logo),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    text = stringResource(id = R.string.app_name),
                    style = MisticaTheme.typography.presetTitle1.copy(lineHeight = TextUnit.Unspecified),
                    fontSize = 26.sp,
                )
            }
        }
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            dashboardState.forEach { element ->
                HorizontalDivider()
                ListRowItem(
                    listRowIcon = ListRowIcon.NormalIcon(
                        painter = painterResource(id = R.drawable.ic_clickable_areas),
                        tint = Color.Unspecified,
                    ),
                    title = stringResource(id = element.nameResId),
                    trailing = { Chevron() },
                    onClick = {
                        navigateToDetail(element.id)
                    },
                )
            }
        }
    }
}
