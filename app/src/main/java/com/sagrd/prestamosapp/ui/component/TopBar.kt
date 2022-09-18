package com.sagrd.prestamosapp.ui.component

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun TopBar(title: String) {
    TopAppBar(
        title = { Text(title) }
    )
}