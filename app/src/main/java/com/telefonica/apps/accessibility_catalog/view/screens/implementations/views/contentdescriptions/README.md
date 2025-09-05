# XML View Implementation for Content Descriptions

This section demonstrates how to implement accessible content descriptions in classic Android Views. The examples focus on:

- Meaningful descriptions
- Avoiding redundancy
- Context-aware descriptions
- Handling decorative images

## Example
```kotlin
val imageView = findViewById<ImageView>(R.id.example_image)
imageView.contentDescription = getString(R.string.meaningful_description)
```

>[!TIP]
>Always provide meaningful and context-aware content descriptions for interactive elements. Avoid redundant descriptions and mark decorative images with `null` contentDescription to prevent them from being announced by screen readers.

