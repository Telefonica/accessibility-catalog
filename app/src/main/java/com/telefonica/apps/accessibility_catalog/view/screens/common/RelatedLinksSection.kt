package com.telefonica.apps.accessibility_catalog.view.screens.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.telefonica.apps.accessibility_catalog.R
import com.telefonica.apps.accessibility_catalog.utilities.TextWithLink
import com.telefonica.apps.accessibility_catalog.view.models.TextLink
import com.telefonica.mistica.compose.title.Title
import com.telefonica.mistica.compose.title.TitleStyle

@Composable
fun RelatedLinksSection(
    relatedLinks: List<TextLink>,
) {
    Title(
        text = stringResource(id = R.string.related_links_title),
        style = TitleStyle.TITLE_2,
        isTitleHeading = true,
    )
    relatedLinks.forEach { relatedLink ->
        Spacer(modifier = Modifier.height(12.dp))
        TextWithLink(textLink = relatedLink, fontSize = 16.sp)
    }
}
