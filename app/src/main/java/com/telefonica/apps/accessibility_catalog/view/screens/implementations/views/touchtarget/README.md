# XML View Implementation for Touch Target

This section demonstrates how to implement touch targets with classic Android Views, focusing on common elements like buttons, chips, and clickable images.

## Using Touch Delegate

Android Views offers an attribute called [TouchDelegate](https://developer.android.com/reference/android/view/View#setTouchDelegate(android.view.TouchDelegate)) in order to modify the default touch target size of the View.
**Example:**
```kotlin
val parent : View = MyViewParent
parent.post { 
    val bounds = Rect()
    // setup bounds
    parent.touchDelegate = TouchDelegate(bounds, DelegateView)
}
```

## Wrapped in a container

Another approach is wrapping your Android View within another View that meets the minimum touch target size requirements defined by accessibility standards.
For example in your code you can create a custom View according to your need:
```kotlin
class ButtonWrapperView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : FrameLayout(context, attrs, defStyle) {

    init {
        minimumHeight = context.dpToPixels(MIN_TOUCH_AREA_IN_DP)
        minimumWidth = context.dpToPixels(MIN_TOUCH_AREA_IN_DP)

        importantForAccessibility = IMPORTANT_FOR_ACCESSIBILITY_YES
    }

    override fun onInitializeAccessibilityEvent(event: AccessibilityEvent?) {
        super.onInitializeAccessibilityEvent(event)
        event?.className = Button::class.java.name
    }
}
```
And then, you can use this custom View directly in you XML file:
```xml
<ButtonWrapperView>
        <Button
            android:id="@+id/wrapped_small_button"
            android:layout_width="12dp"
            android:layout_height="12dp"
            android:clickable="false"
            android:importantForAccessibility="no" />
</ButtonWrapperView>
```

## Custom Action Announcements with AccessibilityNodeInfo

You can add custom action announcements using the `AccessibilityNodeInfo.ActionClick` parameter for the View. This allows you to provide more context and accessibility information for users.
**Example:**
```kotlin
object : View.AccessibilityDelegate() {
    override fun onInitializeAccessibilityNodeInfo(host: View, info: AccessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(host, info)
        info.addAction(
            AccessibilityNodeInfo.AccessibilityAction(
                AccessibilityNodeInfoCompat.ACTION_CLICK,
                customAnnouncemnet
            )
        )
    }
}
```

This approach can be applied to any View with an associated action, providing flexibility and enhanced accessibility.

>[!NOTE]
>The examples above demonstrate the basic implementation. You can further customize the touch target size and action announcements based on your specific needs.
