# XML View Implementation for state descriptions

This section demonstrates how to implement state descriptions configuration with classic Android Views. A custom component with three possible different states has been used as the implementation example.

# Example
```kotlin
val customComponent = findViewById<View>(R.id.custom_component)
ViewCompat.setStateDescription(customComponent, "State 1")
```
