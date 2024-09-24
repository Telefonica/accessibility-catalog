package com.telefonica.apps.accessibility_catalog.view.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.telefonica.apps.accessibility_catalog.domain.GetDashboardListUseCase
import com.telefonica.apps.accessibility_catalog.view.models.DashboardElement
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getDashboardList: GetDashboardListUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<List<DashboardElement>>(emptyList())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = getDashboardList()
        }
    }
}
