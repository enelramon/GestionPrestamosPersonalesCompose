package com.sagrd.prestamosapp.ui.ocupacion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sagrd.prestamosapp.data.local.entity.Ocupacion
import com.sagrd.prestamosapp.data.repository.OcupacionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class OcupacionListUiState(
    val ocupacionList: List<Ocupacion> = emptyList()
)

@HiltViewModel
class OcupacionListViewModel @Inject constructor(
    private val repository: OcupacionRepository
) : ViewModel() {

    var uiState by mutableStateOf(OcupacionListUiState())
        private set

    init {
        viewModelScope.launch {
            repository.getList().collect() { list ->
                uiState = uiState.copy(ocupacionList = list)
            }
        }
    }

}