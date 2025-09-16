package com.telefonica.apps.accessibility_catalog.view.screens.implementations.compose.contentdescriptions

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
        Example1MeaningfulDescription()

        Example2ActionableIcon()

        Example3DecorativeImage()

        Example4ComplexGraphic()

        Example5RedundancyAvoidance()

        Example6ContextualDescriptions()

        Example7PhoneNumberAccessibility()
    }
}

@Composable
private fun Example1MeaningfulDescription() {
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
}

@Composable
private fun Example2ActionableIcon() {
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
}

@Composable
private fun Example3DecorativeImage() {
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
}

@Composable
private fun Example4ComplexGraphic() {
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
}

@Composable
private fun Example5RedundancyAvoidance() {
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
    // region Incorrect example
    Text(
        text = stringResource(R.string.content_descriptions_incorrect),
        style = MaterialTheme.typography.labelLarge,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 4.dp)
    )
    Row(verticalAlignment = Alignment.CenterVertically) {
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
    // endregion
    // region Correct example
    Text(
        text = stringResource(R.string.content_descriptions_correct),
        style = MaterialTheme.typography.labelLarge,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 4.dp)
    )
    val deleteButtonContentDescription =
        stringResource(R.string.content_descriptions_implementation_delete_button)
    Row(
        verticalAlignment = Alignment.CenterVertically,
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
    // endregion
}

@Composable
private fun Example6ContextualDescriptions() {
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
}

@Composable
private fun Example7PhoneNumberAccessibility() {
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
    // region Incorrect example
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
    // endregion
    // region Correct example
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
    // endregion
}
