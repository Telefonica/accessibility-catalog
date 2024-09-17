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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.telefonica.apps.accessibility_catalog.R
import com.telefonica.apps.accessibility_catalog.view.screens.common.AbstractSection
import com.telefonica.apps.accessibility_catalog.view.screens.common.RelatedLink
import com.telefonica.apps.accessibility_catalog.view.screens.common.RelatedLinksSection
import com.telefonica.apps.accessibility_catalog.view.screens.common.RequirementsSection
import com.telefonica.mistica.compose.button.Button
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
                title = { Title(text = "Áreas clicables", style = TitleStyle.TITLE_2) }, // todo dynamic title
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

                    AbstractSection(content = stringResource(id = R.string.touch_target_intro))

                    Spacer(modifier = Modifier.height(20.dp))

                    RequirementsSection(
                        requirements = listOf(
                            stringResource(id = R.string.touch_target_requirement_touch_target),
                            stringResource(id = R.string.touch_target_requirement_space_between),
                            stringResource(id = R.string.touch_target_requirement_custom_announcement),
                        )
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    RelatedLinksSection(
                        relatedLinks = listOf(
                            RelatedLink(
                                url = stringResource(id = R.string.touch_target_related_link_1),
                                name = stringResource(id = R.string.touch_target_related_link_1_name)
                            ),
                            RelatedLink(
                                url = stringResource(id = R.string.touch_target_related_link_2),
                                name = stringResource(id = R.string.touch_target_related_link_2_name)
                            ),
                            RelatedLink(
                                url = stringResource(id = R.string.touch_target_related_link_3),
                                name = stringResource(id = R.string.touch_target_related_link_3_name)
                            ),
                        )
                    )

                    Spacer(modifier = Modifier.height(80.dp))
                }
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp),
                text = stringResource(id = R.string.implementation_button_text),
                onClickListener = {
                    // todo - open implementation
                }
            )
        }
    }
}
