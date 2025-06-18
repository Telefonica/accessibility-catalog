package com.telefonica.apps.accessibility_catalog.view.screens.common

import android.accessibilityservice.AccessibilityServiceInfo
import android.content.Context
import android.view.accessibility.AccessibilityManager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

@Composable
fun isAllAccessibilityServicesDisabledLive(): State<Boolean> {
    val context = LocalContext.current
    return produceState(initialValue = true, context) {
        val accessibilityManager = context.getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager
        val flow = callbackFlow {
            val listener = AccessibilityManager.AccessibilityStateChangeListener {
                trySend(!isAccessibilityServiceEnabled(context))
            }
            accessibilityManager.addAccessibilityStateChangeListener(listener)
            trySend(!isAccessibilityServiceEnabled(context))

            val lifecycleOwner = context as? LifecycleOwner
            val lifecycleObserver = lifecycleOwner?.let {
                LifecycleEventObserver { _, event ->
                    if (event == Lifecycle.Event.ON_RESUME) {
                        trySend(!isAccessibilityServiceEnabled(context))
                    }
                }
            }
            lifecycleObserver?.let { lifecycleOwner.lifecycle.addObserver(it) }

            awaitClose {
                accessibilityManager.removeAccessibilityStateChangeListener(listener)
                lifecycleObserver?.let { lifecycleOwner.lifecycle.removeObserver(it) }
            }
        }
        flow.collect { value = it }
    }
}

private fun isAccessibilityServiceEnabled(context: Context): Boolean {
    val accessibilityManager = context.getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager
    val enabledServices = accessibilityManager.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_ALL_MASK)
    return enabledServices.isNotEmpty()
}
