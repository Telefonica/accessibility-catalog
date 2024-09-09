package com.telefonica.apps.accessibility_catalog.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
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
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
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
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier.padding(all = 16.dp),
            ) {
                Title(
                    modifier = Modifier.semantics { heading() },
                    text = stringResource(id = R.string.abstract_section_title), style = TitleStyle.TITLE_2
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = stringResource(id = R.string.touch_target_intro),
                    style = MisticaTheme.typography.preset4Light,
                    fontSize = 16.sp,
                )
                Spacer(modifier = Modifier.height(16.dp))

                Title(
                    modifier = Modifier.semantics { heading() },
                    text = stringResource(id = R.string.requirements_section_title), style = TitleStyle.TITLE_2
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
                        text = stringResource(id = R.string.touch_target_requirement_touch_target),
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
                        text = stringResource(id = R.string.touch_target_requirement_space_between),
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
                        text = stringResource(id = R.string.touch_target_requirement_custom_announcement),
                        style = MisticaTheme.typography.preset4,
                        fontSize = 16.sp,
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))


                Title(
                    modifier = Modifier.semantics { heading() },
                    text = stringResource(id = R.string.related_links_title), style = TitleStyle.TITLE_2
                )

                val uriHandler = LocalUriHandler.current
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = buildAnnotatedString {
                        val link = LinkAnnotation.Url(
                            url = stringResource(id = R.string.tocuh_target_related_link_1),
                            styles = TextLinkStyles(style = SpanStyle(color = MisticaTheme.colors.textLink)),
                        ) { linkAnnotation ->
                            val url = (linkAnnotation as LinkAnnotation.Url).url
                            uriHandler.openUri(url)
                        }
                        withLink(link) { append("Documentación Android") }
                    },
                    style = MisticaTheme.typography.presetLink,
                    fontSize = 16.sp,
                )
                /*
                Material design: https://m2.material.io/design/layout/spacing-methods.html#touch-targets
                MagentaA11y buttons: https://www.magentaa11y.com/checklist-native/button
                 */

                
            }
        }
    }
}
