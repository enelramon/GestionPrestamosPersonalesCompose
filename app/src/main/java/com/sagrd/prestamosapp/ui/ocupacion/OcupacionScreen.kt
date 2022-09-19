package com.sagrd.prestamosapp.ui.ocupacion

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sagrd.prestamosapp.ui.component.TextError
import com.sagrd.prestamosapp.ui.component.TopBar

@Composable
fun OcupacionScreen(
    ocupacionId: Int = 0,
    viewModel: OcupacionViewModel = hiltViewModel(),
    onNavigateBack: () -> Unit
) {
    Log.i("parametro", ocupacionId.toString())
    val id = remember(ocupacionId) {
        viewModel.FindById(ocupacionId)
        0
    }

    val uiState = viewModel.uiState
    OcupacionesBody(uiState,
        setDescripcion = { viewModel.setDescripcion(it) },
        setSalario = { viewModel.setSalario(it) },
        onNavigateBack = onNavigateBack,
        onSave = {
            if (viewModel.onSave())
                onNavigateBack()
        }
    )
}

@Composable
fun OcupacionesBody(
    uiState: OcupacionUiState,
    onNavigateBack: () -> Unit,
    onSave: () -> Unit,
    setDescripcion: (String) -> Unit,
    setSalario: (String) -> Unit
) {

    Scaffold(
        topBar = { TopBar(title = "Registro de Ocupaciones", onNavigateBack=onNavigateBack) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                onSave()
            }
            ) {
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

            val focusManager = LocalFocusManager.current

            OutlinedTextField(
                value = uiState.descripcion,
                onValueChange = { setDescripcion(it) },
                isError = !uiState.descripcionError.isNullOrEmpty(),
                label = { Text(text = "Descripción") },
                maxLines = 1,
                keyboardOptions = KeyboardOptions.Default.copy(
                    capitalization = KeyboardCapitalization.Words,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                ),
                modifier = Modifier.fillMaxWidth()
            )
            uiState.descripcionError?.let {
                TextError(mensajeError = it)
            }

            OutlinedTextField(
                value = uiState.salario,
                onValueChange = { setSalario(it) },
                isError = !uiState.salarioError.isNullOrEmpty(),
                label = { Text(text = "Salario") },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { onSave() }
                ),
                modifier = Modifier.fillMaxWidth()
            )
            uiState.salarioError?.let {
                TextError(mensajeError = it)
            }
        }
    }
}

/*
@Preview
@Composable
fun BodyPreview() {
    PrestamosAppTheme {
        val state = OcupacionUiState(
            salarioError = "error"
        )
        OcupacionesBody(state, {})
    }

}*/
