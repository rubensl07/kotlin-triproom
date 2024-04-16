package br.senai.sp.jandira.triproom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.triproom.screens.TelaLogin
import br.senai.sp.jandira.triproom.screens.TelaSignin
import br.senai.sp.jandira.triproom.screens.Home
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripRoomTheme{
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = "login"
                    ){
                        composable(route = "login")  { TelaLogin(navigationController) }
                        composable(route = "signin") { TelaSignin(navigationController) }
                        composable(route = "home")   { Home(navigationController) }
                        composable(route = "") { Home(navigationController)}
                    }
                }
            }
        }
    }
}

@Preview ( showSystemUi = true, showBackground = true)
@Composable
fun vazio() {
    val navigationController = rememberNavController()

    TripRoomTheme {
        NavHost(
            navController = navigationController,
            startDestination = ""
        ) {
            composable(route = "") { Home(navigationController)}
        }
    }
}
