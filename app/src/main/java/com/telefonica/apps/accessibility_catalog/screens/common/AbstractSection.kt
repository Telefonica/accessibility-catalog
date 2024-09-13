package com.telefonica.apps.accessibility_catalog.screens.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.telefonica.apps.accessibility_catalog.R
import com.telefonica.mistica.compose.theme.MisticaTheme
import com.telefonica.mistica.compose.title.Title
import com.telefonica.mistica.compose.title.TitleStyle

@Composable
fun AbstractSection(
    content: String,
) {
    Title(
        text = stringResource(id = R.string.abstract_section_title),
        style = TitleStyle.TITLE_2,
        isTitleHeading = true,
    )
    Spacer(modifier = Modifier.height(12.dp))
    Text(
        text = content,
        style = MisticaTheme.typography.preset4Light,
        fontSize = 16.sp,
    )
}
