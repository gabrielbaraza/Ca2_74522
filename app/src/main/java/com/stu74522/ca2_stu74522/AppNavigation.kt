package com.stu74522.ca2_stu74522

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "screen0") {
        composable("screen0") { Screen0(navController) }
        composable("details/ShutterIsland") { Screen1(navController) }
        composable("details/Snatch") { Screen2(navController) }
        composable("details/TaxiDriver") { Screen3(navController) }
        composable("details/PulpFiction") { Screen4(navController) }  // Cela déclare la route "details/PulpFiction"
    }
}
