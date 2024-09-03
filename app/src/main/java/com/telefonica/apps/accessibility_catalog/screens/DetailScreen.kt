package com.telefonica.apps.accessibility_catalog.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.telefonica.apps.accessibility_catalog.R
import com.telefonica.mistica.compose.theme.MisticaTheme
import com.telefonica.mistica.compose.title.Title
import com.telefonica.mistica.compose.title.TitleStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MisticaTheme.colors.brandLow),
                title = { Title(text = "Actions in XML", style = TitleStyle.TITLE_2) },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver atrás")
                    }
                }
            )
        }
    ) { insets ->
        Box(
            modifier = modifier
                .padding(insets)
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier.padding(all = 16.dp),
            ) {
                Title(
                    modifier = Modifier.semantics { heading() },
                    text = stringResource(id = R.string.abstract_section), style = TitleStyle.TITLE_2
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = stringResource(id = R.string.buttons_intro),
                    style = MisticaTheme.typography.preset4Light,
                    fontSize = 16.sp,
                )
                Spacer(modifier = Modifier.height(16.dp))

                Title(
                    modifier = Modifier.semantics { heading() },
                    text = stringResource(id = R.string.requirements_section), style = TitleStyle.TITLE_2
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(modifier = Modifier.padding(start = 8.dp)) {
                    Icon(
                        modifier = Modifier.padding(top = 8.dp),
                        painter = painterResource(id = R.drawable.black_dot),
                        contentDescription = null,
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = stringResource(id = R.string.buttons_requirement_touch_target),
                        style = MisticaTheme.typography.preset4,
                        fontSize = 16.sp,
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Row(modifier = Modifier.padding(start = 8.dp)) {
                    Icon(
                        modifier = Modifier.padding(top = 8.dp),
                        painter = painterResource(id = R.drawable.black_dot),
                        contentDescription = null,
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = stringResource(id = R.string.buttons_requirement_space_between),
                        style = MisticaTheme.typography.preset4,
                        fontSize = 16.sp,
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Row(modifier = Modifier.padding(start = 8.dp)) {
                    Icon(
                        modifier = Modifier.padding(top = 8.dp),
                        painter = painterResource(id = R.drawable.black_dot),
                        contentDescription = null,
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = stringResource(id = R.string.buttons_requirement_custom_announcement),
                        style = MisticaTheme.typography.preset4,
                        fontSize = 16.sp,
                    )
                }
            }
        }
        // todo: añadir la fuente como Link: https://support.google.com/accessibility/android/answer/7101858?hl=en#:~:text=Consider%20making%20touch%20targets%20at,touchscreen%20objects%20is%207%2D10mm.
    }
}
