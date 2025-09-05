package com.telefonica.apps.accessibility_catalog.view.screens.implementations.compose.contentdescriptions

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.telefonica.apps.accessibility_catalog.R

@Composable
fun ContentDescriptionsCompose() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        // 1. Meaningful description (Informative image)
        Text(
            text = stringResource(R.string.content_descriptions_informative_title),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.content_descriptions_informative_explanation),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.sunnyweather),
            contentDescription = stringResource(R.string.content_descriptions_implementation_weather_description),
            modifier = Modifier.size(96.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))

        // 2. Actionable icon (Context-aware/action description)
        Text(
            text = stringResource(R.string.content_descriptions_actionable_title),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.content_descriptions_actionable_explanation),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        IconButton(onClick = { /* Handle delete */ }) {
            Image(
                painter = painterResource(id = R.drawable.baseline_close_24),
                contentDescription = stringResource(R.string.content_descriptions_implementation_delete_button),
                modifier = Modifier.size(48.dp)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))

        // 3. Decorative image (no content description)
        Text(
            text = stringResource(R.string.content_descriptions_decorative_title),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.content_descriptions_decorative_explanation),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.black_dot),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))

        // 4. Complex graphic (context-aware/meaningful description)
        Text(
            text = stringResource(R.string.content_descriptions_complex_title),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.content_descriptions_implementation_chart_description),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.sales_per_quarter),
            contentDescription = stringResource(R.string.content_descriptions_implementation_chart_description),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))

        // 5. Redundancy avoidance (bad and good example)
        Text(
            text = stringResource(R.string.content_descriptions_redundancy_title),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.content_descriptions_redundancy_explanation),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        // Incorrect example
        Text(
            text = stringResource(R.string.content_descriptions_incorrect),
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            IconButton(onClick = { /* Handle action */ }) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_close_24),
                    contentDescription = stringResource(R.string.content_descriptions_implementation_delete_button),
                    modifier = Modifier.size(32.dp)
                )
            }
            Text(
                text = stringResource(R.string.content_descriptions_implementation_delete_button),
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Text(
            text = stringResource(R.string.content_descriptions_redundancy_incorrect_explanation),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(start = 40.dp, bottom = 12.dp)
        )
        // Correct example
        Text(
            text = stringResource(R.string.content_descriptions_correct),
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        val deleteButtonContentDescription = stringResource(R.string.content_descriptions_implementation_delete_button)
        Row(
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
            modifier = Modifier
                .clickable { /* Handle action */ }
                .semantics {
                    contentDescription = deleteButtonContentDescription
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_close_24),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .clearAndSetSemantics {}
            )
            Text(
                text = stringResource(R.string.content_descriptions_implementation_delete_button),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clearAndSetSemantics {}
            )
        }
        Text(
            text = stringResource(R.string.content_descriptions_redundancy_correct_explanation),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(start = 40.dp, bottom = 24.dp)
        )

        // 6. Context-aware (status indicator)
        Text(
            text = stringResource(R.string.content_descriptions_contextual_title),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.content_descriptions_contextual_explanation),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row {
            Image(
                painter = painterResource(id = R.drawable.black_dot),
                contentDescription = stringResource(R.string.content_descriptions_status_online),
                modifier = Modifier.size(16.dp)
            )
            Text(
                text = stringResource(R.string.content_descriptions_status_online_label),
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))

        // 7. Phone Number Accessibility
        Text(
            text = stringResource(R.string.content_descriptions_phone_number_title),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.content_descriptions_phone_number_explanation),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        // Incorrect example
        Text(
            text = stringResource(R.string.content_descriptions_phone_number_incorrect_label),
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
        )
        Text(
            text = stringResource(R.string.content_descriptions_phone_number_raw),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
        )
        Text(
            text = stringResource(R.string.content_descriptions_phone_number_incorrect_explanation),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        // Correct example
        Text(
            text = stringResource(R.string.content_descriptions_phone_number_correct_label),
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
        )
        val spacedPhoneNumber = stringResource(R.string.content_descriptions_phone_number_spaced)
        Text(
            text = stringResource(R.string.content_descriptions_phone_number_raw),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.semantics {
                contentDescription = spacedPhoneNumber
            }
        )
        Text(
            text = stringResource(R.string.content_descriptions_phone_number_correct_explanation),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}
