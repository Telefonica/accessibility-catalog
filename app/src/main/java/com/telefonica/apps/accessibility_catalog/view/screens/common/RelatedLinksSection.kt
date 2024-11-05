package com.telefonica.apps.accessibility_catalog.view.screens.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.telefonica.apps.accessibility_catalog.R
import com.telefonica.apps.accessibility_catalog.view.models.RelatedLink
import com.telefonica.mistica.compose.theme.MisticaTheme
import com.telefonica.mistica.compose.title.Title
import com.telefonica.mistica.compose.title.TitleStyle

@Composable
fun RelatedLinksSection(
    relatedLinks: List<RelatedLink>,
) {
    val uriHandler = LocalUriHandler.current

    Title(
        text = stringResource(id = R.string.related_links_title),
        style = TitleStyle.TITLE_2,
        isTitleHeading = true,
    )
    relatedLinks.forEach { relatedLink ->
        val url = stringResource(id = relatedLink.url)

        Spacer(modifier = Modifier.height(12.dp))
        Text(
            modifier = Modifier
                .clickable(onClickLabel = stringResource(id = R.string.accessibility_go_to_website_label)) {
                    uriHandler.openUri(url)
                },
            text = buildAnnotatedString {
                val link = LinkAnnotation.Url(
                    url = url,
                    styles = TextLinkStyles(style = SpanStyle(color = MisticaTheme.colors.textLink)),
                ) { linkAnnotation ->
                    val url = (linkAnnotation as LinkAnnotation.Url).url
                    uriHandler.openUri(url)
                }
                withLink(link) { append(stringResource(id = relatedLink.nameResId)) }
            },
            style = MisticaTheme.typography.presetLink,
            fontSize = 16.sp,
        )
    }
}
