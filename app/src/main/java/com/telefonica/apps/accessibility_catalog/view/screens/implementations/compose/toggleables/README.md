# Compose Implementation for Toggleables

This section demonstrates how to implement custom Toggleables in Jetpack Compose with a very simple example showing a Switch and a CheckBox components.
```kotlin

var isSwitchChecked: Boolean by remember { mutableStateOf(false) }

Row(
    modifier = Modifier
        .fillMaxWidth()
        .toggleable(
            value = isChecked,
            role = role,
            onValueChange = onToggle,
        ),
) {
    Icon(
        painter = painterResource(id = R.drawable.baseline_ads_click_24),
        contentDescription = null,
    )

    Column {
        Text(text = stringResource(R.string.toggleables_implementation_custom_title), fontSize = 18.sp, color = Color.Black)
        Text(text = stringResource(R.string.toggleables_implementation_custom_subtitle), fontSize = 14.sp, color = Color.Gray)
    }

    Switch(
        checked = isSwitchChecked,
        onCheckedChange = null
    )
}
```