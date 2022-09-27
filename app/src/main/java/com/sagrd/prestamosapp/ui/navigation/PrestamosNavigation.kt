package com.sagrd.prestamosapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sagrd.prestamosapp.ui.ocupacion.OcupacionListaScreen
import com.sagrd.prestamosapp.ui.ocupacion.OcupacionScreen


@Composable
fun PrestamosNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.OcupacionList.route
    ) {
        composable(Screen.OcupacionList.route) {
            OcupacionListaScreen(
                onNavigateToOcupacion =
                { ocupacionId ->
                    navController.navigate(Screen.OcupacionForm.route + "/$ocupacionId")
                })
        }
        composable(
            Screen.OcupacionForm.route + "/{ocupacionId}",
            arguments = listOf(navArgument("ocupacionId") { type = NavType.IntType })
        ) { backStackEntry ->

            val ocupacionId = backStackEntry.arguments?.getInt("ocupacionId") ?: 0
            OcupacionScreen(ocupacionId,
                onNavigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}
