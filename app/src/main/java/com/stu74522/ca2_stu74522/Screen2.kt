package com.stu74522.ca2_stu74522;

import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun Screen2(navController: NavController){
    val SnatchMovie = listMovie.firstOrNull { it.title == "Snatch" }

    SnatchMovie?.let { movie ->
        makeScreen(movie,navController)
    }
}