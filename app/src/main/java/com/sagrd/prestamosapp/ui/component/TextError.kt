package com.sagrd.prestamosapp.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TextError(mensajeError: String) {
    Text(
        text = mensajeError,
        style = MaterialTheme.typography.caption,
        color = MaterialTheme.colors.error,
        modifier = Modifier.padding(start = 8.dp)
    )
}

