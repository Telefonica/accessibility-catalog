# Compose Implementation for Headings

This section demonstrates how to implement Heading configuration in Jetpack Compose with a very simple example showing two headings.
```kotlin
Text(
    modifier = Modifier.semantics { heading() },
    text = "One Heading"
)
```
>[!TIP]
>Remember to use headings when displaying a large amount of information on the screen to help users easily find the section they are interested in.
