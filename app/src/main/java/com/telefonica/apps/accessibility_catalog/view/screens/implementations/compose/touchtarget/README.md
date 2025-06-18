# Compose Implementation for Touch Target

This section demonstrates how to implement touch targets in Jetpack Compose, focusing on common elements like buttons, chips, and clickable images.

## Default Implementation

Jetpack Compose automatically provides a minimal touch target size for composable elements with click actions.
**Example:**
```kotlin
Button(onClick = { /* Your action */ }) { Text("Click me") }
```

**Clickable Images:**
For clickable images, wrap them within an `IconButton` composable to leverage the default touch target configuration.
```kotlin
IconButton(onClick = { /* Your action */ }) { Image(painterResource( id = R.drawable.my_image) ,  contentDescription = "My Image") }
```

## Custom Action Announcements with Semantics

You can add custom action announcements using the `semantics` composable modifier. This allows you to provide more context and accessibility information for users.
**Example:**
```kotlin
Button( onClick = { /* Your action */ }, modifier = Modifier.semantics { onClick(action = { /* Your custom action */ }, label = "Click to perform action") } ) { Text("Click me") }
```

This approach can be applied to any Composable with an associated action, providing flexibility and enhanced accessibility.

>[!NOTE]
>The examples above demonstrate the basic implementation. You can further customize the touch target size and action announcements based on your specific needs.
