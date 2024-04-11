package com.stu74522.ca2_stu74522

import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun Screen3(navController: NavController){
    val TaxiDriverMovie = listMovie.firstOrNull { it.title == "Taxi Driver" }

    TaxiDriverMovie?.let { movie ->
        makeScreen(movie,navController)
    }
}