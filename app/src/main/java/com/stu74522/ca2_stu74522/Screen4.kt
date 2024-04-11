package com.stu74522.ca2_stu74522

import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun Screen4(navController: NavController){
    val PulpFictionMovie = listMovie.firstOrNull { it.title == "Pulp Fiction" }

    PulpFictionMovie?.let { movie ->
        makeScreen(movie,navController)
    }
}