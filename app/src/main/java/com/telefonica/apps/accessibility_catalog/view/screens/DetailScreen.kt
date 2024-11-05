package com.telefonica.apps.accessibility_catalog.view.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.telefonica.apps.accessibility_catalog.R
import com.telefonica.apps.accessibility_catalog.view.screens.common.AbstractSection
import com.telefonica.apps.accessibility_catalog.view.screens.common.RelatedLinksSection
import com.telefonica.apps.accessibility_catalog.view.screens.common.RequirementsSection
import com.telefonica.apps.accessibility_catalog.view.viewmodels.DetailViewModel
import com.telefonica.mistica.compose.button.Button
import com.telefonica.mistica.compose.theme.MisticaTheme
import com.telefonica.mistica.compose.title.Title
import com.telefonica.mistica.compose.title.TitleStyle
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    elementId: UUID,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = hiltViewModel(),
    onBackPressed: () -> Unit,
    onImplementationClick: () -> Unit,
) {
    val detailState = viewModel.state.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.init(elementId)
    }

    detailState.value?.let { elementDetail ->
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = MisticaTheme.colors.brandLow),
                    title = { Title(text = stringResource(id = elementDetail.nameResId), style = TitleStyle.TITLE_2) },
                    navigationIcon = {
                        IconButton(onClick = onBackPressed) {
                            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = stringResource(id = R.string.accessibility_back_button))
                        }
                    }
                )
            }
        ) { insets ->
            Box(
                modifier = modifier
                    .padding(insets)
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))
                        AbstractSection(content = stringResource(id = elementDetail.abstractResId))

                        if (elementDetail.requirementsResId.isNotEmpty()) {
                            Spacer(modifier = Modifier.height(20.dp))
                            RequirementsSection(requirements = elementDetail.requirementsResId.map { stringResource(id = it) })
                        }

                        if (elementDetail.relatedLinksResId.isNotEmpty()) {
                            Spacer(modifier = Modifier.height(20.dp))
                            RelatedLinksSection(relatedLinks = elementDetail.relatedLinksResId)
                        }

                        Spacer(modifier = Modifier.height(80.dp))
                    }
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 16.dp),
                    text = stringResource(id = R.string.implementation_text),
                    onClickListener = onImplementationClick
                )
            }
        }
    }
}
