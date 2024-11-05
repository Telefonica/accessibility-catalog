package com.telefonica.apps.accessibility_catalog.view.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.telefonica.apps.accessibility_catalog.domain.GetDetailUseCase
import com.telefonica.apps.accessibility_catalog.view.models.AccessibilityDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getAccessibilityDetailUseCase: GetDetailUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<AccessibilityDetail?>(null)
    val state = _state.asStateFlow()

    fun init(elementId: UUID) {
        viewModelScope.launch {
            _state.value = getAccessibilityDetailUseCase(elementId)
        }
    }
}
