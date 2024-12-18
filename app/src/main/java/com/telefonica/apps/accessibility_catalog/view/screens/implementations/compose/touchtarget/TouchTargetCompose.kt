package com.telefonica.apps.accessibility_catalog.view.screens.implementations.compose.touchtarget

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.telefonica.apps.accessibility_catalog.R
import com.telefonica.mistica.compose.theme.MisticaTheme
import com.telefonica.mistica.compose.title.Title
import com.telefonica.mistica.compose.title.TitleStyle

@Composable
fun TouchTarget() {
    val context = LocalContext.current
    val feedbackClicked = stringResource(R.string.touch_target_implementation_feedback_clicked)

    Column {
        //region Default with click action
        // Composable elements with onClick value are usually set by default with a min touch target size aligned with the accessibility standard.
        Title(
            style = TitleStyle.TITLE_1,
            text = "Default with click action",
        )

        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
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

            AssistChip(
                modifier = Modifier
                    .wrapContentWidth()
                    .height(20.dp),
                onClick = {
                    Toast
                        .makeText(context, feedbackClicked, Toast.LENGTH_SHORT)
                        .show()
                },
                label = {
                    Text("Small chip")
                }
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
        //endregion

        Spacer(modifier = Modifier.size(8.dp))

        //region Custom action announcement
        Title(
            style = TitleStyle.TITLE_1,
            text = stringResource(R.string.touch_target_implementation_custom_tap_announcement_title),
        )

        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val sendAction = stringResource(R.string.touch_target_implementation_send_button_action)
            Button(
                modifier = Modifier.semantics {
                    onClick(label = sendAction, action = null)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MisticaTheme.colors.buttonPrimaryBackground
                ),
                onClick = { Toast.makeText(context, feedbackClicked, Toast.LENGTH_SHORT).show() },
            ) {
                Text(text = stringResource(R.string.touch_target_implementation_send_button_text), fontSize = 14.sp)
            }

            val filterAction = stringResource(R.string.touch_target_implementation_filter_chip_action)
            AssistChip(
                modifier = Modifier.semantics {
                    onClick(label = filterAction, action = null)
                },
                onClick = {
                    Toast
                        .makeText(context, feedbackClicked, Toast.LENGTH_SHORT)
                        .show()
                },
                label = {
                    Text(stringResource(R.string.touch_target_implementation_filter_chip_text), fontSize = 14.sp)
                }
            )

            val closeAction = stringResource(R.string.touch_target_implementation_close_image_button_action)
            IconButton(
                modifier = Modifier.semantics {
                    onClick(label = closeAction, action = null)
                },
                onClick = { Toast.makeText(context, feedbackClicked, Toast.LENGTH_SHORT).show() },
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = stringResource(R.string.touch_target_implementation_close_image_button_text),
                )
            }
        }
        //endregion
    }
}
