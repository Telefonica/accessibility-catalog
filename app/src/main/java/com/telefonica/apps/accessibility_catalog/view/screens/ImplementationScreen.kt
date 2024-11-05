package com.telefonica.apps.accessibility_catalog.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.telefonica.apps.accessibility_catalog.R
import com.telefonica.apps.accessibility_catalog.view.screens.implementations.views.toggleables.CustomToggleablesView
import com.telefonica.mistica.compose.title.Title
import com.telefonica.mistica.compose.title.TitleStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImplementationScreen(
    onCloseClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.implementation_text),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onCloseClick) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = stringResource(id = R.string.accessibility_close_button)
                        )
                    }
                },
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Title(
                text = stringResource(id = R.string.xml_views_implementation_title),
                style = TitleStyle.TITLE_2,
                isTitleHeading = true,
            )

            Spacer(modifier = Modifier.height(12.dp))

            AndroidView(
                modifier = Modifier
                    .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(12.dp))
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                factory = { context ->
                    CustomToggleablesView(context = context)
                })

            Spacer(modifier = Modifier.height(20.dp))

            Title(
                text = stringResource(id = R.string.compose_implementation_title),
                style = TitleStyle.TITLE_2,
                isTitleHeading = true,
            )

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(Color.Blue)
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
