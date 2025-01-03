package com.telefonica.apps.accessibility_catalog.utilities

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.TextUnit
import com.telefonica.apps.accessibility_catalog.R
import com.telefonica.apps.accessibility_catalog.view.models.TextLink
import com.telefonica.mistica.compose.theme.MisticaTheme

@Composable
fun TextWithLink(
    textLink: TextLink,
    fontSize: TextUnit = TextUnit.Unspecified,
) {
    val uriHandler = LocalUriHandler.current
    val url = stringResource(id = textLink.url)

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
                uriHandler.openUri(
                    (linkAnnotation as LinkAnnotation.Url).url
                )
            }
            withLink(link) { append(stringResource(id = textLink.nameResId)) }
        },
        style = MisticaTheme.typography.presetLink,
        fontSize = fontSize,
    )
}
