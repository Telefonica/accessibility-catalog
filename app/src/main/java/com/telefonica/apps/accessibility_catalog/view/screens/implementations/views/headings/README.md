# XML View Implementation for Headings

This section demonstrates how to implement Heading configuration with classic Android Views in a very simple example showing two headings.
```kotlin
val heading = findViewById<TextView>(R.id.heading_text)
ViewCompat.setAccessibilityHeading(heading, true)
```
>[!TIP]
>Remember to use headings when displaying a large amount of information on the screen to help users easily find the section they are interested in.
