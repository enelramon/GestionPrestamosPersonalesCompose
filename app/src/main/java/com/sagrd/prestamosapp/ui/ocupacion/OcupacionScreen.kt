package com.sagrd.prestamosapp.ui.ocupacion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sagrd.prestamosapp.ui.component.TextError
import com.sagrd.prestamosapp.ui.component.TopBar
import com.sagrd.prestamosapp.ui.theme.PrestamosAppTheme

@Composable
fun OcupacionScreen(
    viewModel: OcupacionViewModel = hiltViewModel(),
) {
    val uiState = viewModel.uiState
    OcupacionesBody(uiState,
        onSave = { viewModel.onSave() }
    )
}

@Composable
fun OcupacionesBody(uiState: OcupacionUiState, onSave: () -> Unit) {

    Scaffold(
        topBar = { TopBar(title = "Registro de Ocupaciones") },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                onSave()
            }) {
                Icon(
                    imageVector = Icons.Default.Save,
                    contentDescription = "Guardar"
                )
            }
        }
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(8.dp)
        ) {

            OutlinedTextField(
                value = uiState.descripcion,
                onValueChange = { uiState.descripcion = it },
                isError = !uiState.descripcionError.isNullOrEmpty(),
                label = { Text(text = "Descripción") },
                modifier = Modifier.fillMaxWidth()
            )
            uiState.descripcionError?.let {
                TextError(mensajeError = it)
            }

            OutlinedTextField(
                value = uiState.salario.toString(),
                onValueChange = { uiState.salario = it.toDoubleOrNull() ?: 0.0 },
                isError = !uiState.salarioError.isNullOrEmpty(),
                label = { Text(text = "Salario") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            uiState.salarioError?.let {
                TextError(mensajeError = it)
            }
        }
    }
}

@Preview
@Composable
fun BodyPreview() {
    PrestamosAppTheme {
        val state = OcupacionUiState(
            salarioError = "error"
        )
        OcupacionesBody(state, {})
    }

}