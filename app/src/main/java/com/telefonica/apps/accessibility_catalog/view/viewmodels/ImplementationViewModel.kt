package com.telefonica.apps.accessibility_catalog.view.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.telefonica.apps.accessibility_catalog.domain.GetImplementationUseCase
import com.telefonica.apps.accessibility_catalog.view.models.AccessibilityImplementation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class ImplementationViewModel @Inject constructor(
    private val getImplementationUseCase: GetImplementationUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<AccessibilityImplementation?>(null)
    val state = _state.asStateFlow()

    fun init(elementId: UUID) {
        viewModelScope.launch {
            _state.value = getImplementationUseCase(elementId)
        }
    }
}
