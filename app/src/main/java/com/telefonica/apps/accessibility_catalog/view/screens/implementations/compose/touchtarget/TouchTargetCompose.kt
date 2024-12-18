package com.telefonica.apps.accessibility_catalog.view.screens.implementations.compose.touchtarget

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.telefonica.apps.accessibility_catalog.R
import com.telefonica.mistica.compose.tag.Tag
import com.telefonica.mistica.compose.theme.MisticaTheme
import com.telefonica.mistica.tag.TagView.Companion.TYPE_PROMO

// Composable elements with onClick value are usually set by default with a min touch target size aligned with the accessibility standard.
@Composable
fun TouchTarget() {
    val context = LocalContext.current
    val feedbackClicked = stringResource(R.string.touch_target_implementation_feedback_clicked)

    Row(
        modifier = Modifier
            .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .padding(all = 12.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Button(
            modifier = Modifier.height(34.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MisticaTheme.colors.buttonPrimaryBackground
            ),
            onClick = { Toast.makeText(context, feedbackClicked, Toast.LENGTH_SHORT).show() },
        ) {
            Text(text = stringResource(R.string.touch_target_implementation_small_button), fontSize = 12.sp)
        }

        Tag(
            modifier = Modifier
                .sizeIn(minHeight = 28.dp)
                .clickable {
                    Toast
                        .makeText(context, feedbackClicked, Toast.LENGTH_SHORT)
                        .show()
                },
            text = stringResource(R.string.touch_target_implementation_small_chip),
            style = TYPE_PROMO,
        )

        // Wrap clickable icons inside IconButton to take advantage of the default accessibility settings.
        IconButton(
            onClick = { Toast.makeText(context, feedbackClicked, Toast.LENGTH_SHORT).show() },
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = stringResource(R.string.touch_target_implementation_small_icon),
                modifier = Modifier.size(12.dp)
            )
        }
    }
}