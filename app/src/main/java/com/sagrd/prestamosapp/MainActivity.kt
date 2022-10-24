package com.sagrd.prestamosapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.sagrd.prestamosapp.data.remote.dto.LoginResponseDto
import com.sagrd.prestamosapp.data.repository.EjemploApiRepository
import com.sagrd.prestamosapp.ui.navigation.PrestamosNavigation
import com.sagrd.prestamosapp.ui.theme.PrestamosAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var ejemploApiRepository: EjemploApiRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrestamosAppTheme {
                val scope = rememberCoroutineScope()
                var response by remember {
                    mutableStateOf(LoginResponseDto())
                }
                Column() {
                    OutlinedButton(onClick = {
                        scope.launch {
                            response= ejemploApiRepository.Login("test@sagrd.com", "Sag.138090")
                        }
                    }) {
                        Text("Login")
                    }

                    Text(text = response.toString())
                }

                /*val navController = rememberNavController()

                PrestamosNavigation(navController)*/

            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}