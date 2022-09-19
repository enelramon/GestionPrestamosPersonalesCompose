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
    val ocupacionId: Int?= null,
    val descripcion: String = "",
    val descripcionError: String? = null,
    val salario: String = "",
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

        if ((uiState.salario.toDoubleOrNull() ?: 0.0) <= 1) {
            uiState = uiState.copy(salarioError = "Debe ingresar un salario")
            isValid = false
        }

        return isValid
    }

    fun onSave(): Boolean {

        if (validar()) {
            save()
            return true
        }

        return false
    }

    private fun save() {
        viewModelScope.launch {
            repository.insert(
                Ocupacion(
                    ocupacionId = uiState.ocupacionId,
                    descripcion = uiState.descripcion,
                    salario = uiState.salario.toDoubleOrNull() ?: 0.0
                )
            )
        }
    }

    fun setDescripcion(descripcion: String) {
        uiState = uiState.copy(descripcion = descripcion)
    }

    fun setSalario(salario: String) {
        val valor = salario.toDoubleOrNull() ?: 0.0
        uiState = uiState.copy(
            salario = salario,
            salarioError = if (valor <= 1) "Debe ingresar un salario" else null
        )
    }

    fun FindById(ocupacionId: Int) {
        viewModelScope.launch {
            repository.find(ocupacionId)?.let {
                uiState = uiState.copy(
                    ocupacionId = it.ocupacionId,
                    descripcion = it.descripcion,
                    salario = it.salario.toString()
                )
            }

        }
    }
}