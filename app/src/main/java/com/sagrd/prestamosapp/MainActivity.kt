package com.sagrd.prestamosapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sagrd.prestamosapp.ui.ocupacion.OcupacionListaScreen
import com.sagrd.prestamosapp.ui.ocupacion.OcupacionScreen
import com.sagrd.prestamosapp.ui.theme.PrestamosAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrestamosAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.OcupacionList.route
                ) {
                    composable(Screen.OcupacionList.route) {
                        OcupacionListaScreen()
                        { ocupacionId ->
                            navController.navigate(Screen.OcupacionForm.route + "/$ocupacionId")
                        }
                    }
                    composable(
                        Screen.OcupacionForm.route + "/{ocupacionId}",
                        arguments = listOf(navArgument("ocupacionId") { type = NavType.IntType })
                    ) { backStackEntry ->

                        val ocupacionId = backStackEntry.arguments?.getInt("ocupacionId") ?: 0
                        OcupacionScreen(ocupacionId, onNavigateBack = {
                            navController.navigateUp()
                        })
                    }
                }
            }
        }
    }
}

sealed class Screen(val route: String) {
    object OcupacionList : Screen("OcupacionList")
    object OcupacionForm : Screen("Ocupacion")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}