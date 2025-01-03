package com.telefonica.apps.accessibility_catalog.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.telefonica.apps.accessibility_catalog.R
import com.telefonica.apps.accessibility_catalog.view.viewmodels.ImplementationViewModel
import com.telefonica.mistica.compose.title.Title
import com.telefonica.mistica.compose.title.TitleStyle
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImplementationScreen(
    elementId: UUID,
    viewModel: ImplementationViewModel = hiltViewModel(),
    onCloseClick: () -> Unit,
) {

    val implementationState = viewModel.state.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.init(elementId)
    }

    implementationState.value?.let { elementImplementation ->
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
                if (elementImplementation.xmlViewImplementation != null) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Title(
                        text = stringResource(id = R.string.xml_views_implementation_title),
                        style = TitleStyle.TITLE_2,
                        isTitleHeading = true,
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    elementImplementation.xmlViewImplementation.invoke()
                }

                if (elementImplementation.composeImplementation != null) {
                    Spacer(modifier = Modifier.height(28.dp))
                    Title(
                        text = stringResource(id = R.string.compose_implementation_title),
                        style = TitleStyle.TITLE_2,
                        isTitleHeading = true,
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    elementImplementation.composeImplementation.invoke()
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
