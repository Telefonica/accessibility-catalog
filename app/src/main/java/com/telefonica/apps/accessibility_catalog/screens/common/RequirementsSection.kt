package com.telefonica.apps.accessibility_catalog.screens.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.telefonica.apps.accessibility_catalog.R
import com.telefonica.mistica.compose.theme.MisticaTheme
import com.telefonica.mistica.compose.title.Title
import com.telefonica.mistica.compose.title.TitleStyle

@Composable
fun RequirementsSection(
    requirements: List<String>,
) {
    Title(
        text = stringResource(id = R.string.requirements_section_title),
        style = TitleStyle.TITLE_2,
        isTitleHeading = true,
    )
    requirements.forEach { requirement ->
        Spacer(modifier = Modifier.height(12.dp))
        Row(modifier = Modifier.padding(start = 8.dp)) {
            Icon(
                modifier = Modifier.padding(top = 8.dp),
                painter = painterResource(id = R.drawable.black_dot),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = requirement,
                style = MisticaTheme.typography.preset4Light,
                fontSize = 16.sp,
            )
        }
    }
}
