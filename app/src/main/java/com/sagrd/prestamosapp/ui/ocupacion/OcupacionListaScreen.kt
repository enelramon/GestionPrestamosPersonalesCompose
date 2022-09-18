package com.sagrd.prestamosapp.ui.ocupacion

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sagrd.prestamosapp.data.local.entity.Ocupacion
import com.sagrd.prestamosapp.ui.component.TopBar
import com.sagrd.prestamosapp.ui.theme.PrestamosAppTheme

@Composable
fun OcupacionListaScreen(
    onNavigateToOcupacion: (Int) -> Unit,
    viewModel: OcupacionListViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState

    OcupacionListaBody(uiState.ocupacionList, onNavigateToOcupacion)
}

@Composable
fun OcupacionListaBody(ocupacionesList: List<Ocupacion>, onNavigateToOcupacion: (Int) -> Unit) {
    Scaffold(
        topBar = { TopBar(title = "Ocupaciones") },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                onNavigateToOcupacion(0)
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar"
                )
            }
        }
    )
    {
        Box(
            modifier = Modifier
                .padding(it)
                .padding(8.dp)
        ) {
            OcupacionesList(ocupacionesList) { ocupacionId ->
                onNavigateToOcupacion(ocupacionId)
            }
        }
    }
}

@Composable
fun OcupacionesList(ocupacionesList: List<Ocupacion>, onNavigateToOcupacion: (Int) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(ocupacionesList) { ocupacion ->
            OcupacionRow(ocupacion) { ocupacionId ->
                onNavigateToOcupacion(ocupacionId)
            }
        }
    }
}

@Composable
fun OcupacionRow(ocupacion: Ocupacion, onOcupacionClick: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(
                onClick = {
                    onOcupacionClick(ocupacion.ocupacionId)
                }
            )
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = ocupacion.descripcion,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.weight(4f)
            )
            Text(
                text = ocupacion.salario.toString(),
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.weight(2f)
            )
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            color = Color.LightGray
        )
    }
}

@Preview
@Composable
fun OcupacionListaBodyPreview() {
    PrestamosAppTheme {
        val ocupacionList = listOf(
            Ocupacion(
                ocupacionId = 1,
                descripcion = "Profesor",
                salario = 10000.0
            ),
            Ocupacion(
                ocupacionId = 2,
                descripcion = "Ingeniero",
                salario = 12000.0
            ),
            Ocupacion(
                ocupacionId = 1,
                descripcion = "Abogado",
                salario = 11000.0
            )
        )

        OcupacionListaBody(ocupacionList, {})
    }

}