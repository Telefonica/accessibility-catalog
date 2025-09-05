# Compose Implementation for Content Descriptions

This section demonstrates how to implement accessible content descriptions using Jetpack Compose. The examples focus on:

- Meaningful descriptions
- Avoiding redundancy
- Context-aware descriptions
- Handling decorative images

## Example
```kotlin
Image(
    painter = painterResource(id = R.drawable.example_image),
    contentDescription = stringResource(R.string.meaningful_description)
)
```

>[!TIP]
>Always provide meaningful and context-aware content descriptions for interactive elements. Avoid redundant descriptions and use `contentDescription = null` for decorative images so they are ignored by screen readers.

