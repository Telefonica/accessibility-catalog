# Compose Implementation for state descriptions

This section demonstrates how to implement state descriptions configuration in Jetpack Compose. A custom component with three possible different states has been used as the implementation example.

# Example
```kotlin
CustomComponent(
    modifier = Modifier.semantics {
        stateDescription = "State 1"
    },
)
