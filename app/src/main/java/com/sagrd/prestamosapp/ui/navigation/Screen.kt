package com.sagrd.prestamosapp.ui.navigation

sealed class Screen(val route: String) {
    object OcupacionList : Screen("OcupacionList")
    object OcupacionForm : Screen("Ocupacion")
}
