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

data class OcupacionUiState(
    var descripcion: String = "",
    val descripcionError: String? = null,
    var salario: Double = 0.0,
    val salarioError: String? = null
)

@HiltViewModel
class OcupacionViewModel @Inject constructor(
    private val repository: OcupacionRepository
) : ViewModel() {

    var uiState by mutableStateOf(OcupacionUiState())
        private set

    fun validar(): Boolean {
        var isValid = true

        if (uiState.descripcion.isEmpty()) {
            uiState = uiState.copy(descripcionError = "Debe ingresar una descripción")
            isValid = false
        }

        if (uiState.salario <= 0) {
            uiState = uiState.copy(salarioError = "Debe ingresar un salario")
            isValid = false
        }

        return isValid
    }

    fun onSave() {
        if (validar()) {
            save()
        }
    }

    private fun save() {
        viewModelScope.launch {
            repository.insert(
                Ocupacion(
                    descripcion = uiState.descripcion,
                    salario = uiState.salario
                )
            )
        }
    }
}