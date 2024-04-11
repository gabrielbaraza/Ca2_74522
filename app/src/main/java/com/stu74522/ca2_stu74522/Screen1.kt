package com.stu74522.ca2_stu74522
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController






@Composable
fun makeScreen(movie: Movie, navController: NavController) {
    var seatsSelected by remember { mutableStateOf(movie.seatsSelected) }
    var seatsRemaining by remember { mutableStateOf(movie.seatsRemaining) }
    val lightPurple = Color(0xFFADEFD1)


    Column(
        modifier = Modifier.fillMaxSize()
            .background(lightPurple)
    ) {
        IconButton(
            onClick = { navController.navigate("screen0") },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        }
        Image(
            painter = painterResource(id = movie.image),
            contentDescription = "${movie.title} image",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = movie.title,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "Starring: ${movie.starring.joinToString(", ")}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Running time: ${movie.runningTimeMins} mins",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = movie.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Row(modifier = Modifier.padding(16.dp)) {
            Button(onClick = {
                if (seatsSelected > 0) {
                    seatsSelected--
                    seatsRemaining++
                    movie.seatsSelected--
                    movie.seatsRemaining++
                }
            }, enabled = seatsSelected > 0) {
                Text("-")
            }

            Text("Seats Selected: $seatsSelected")

            Button(onClick = {
                if (seatsRemaining > 0) {
                    seatsSelected++
                    seatsRemaining--
                    movie.seatsSelected++
                    movie.seatsRemaining--
                }
            }, enabled = seatsRemaining > 0) {
                Text("+")
            }
        }

        Text("Seats Remaining: $seatsRemaining")

        Button(
            onClick = {
                navController.navigate("screen0")
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Validate")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen1(navController: NavController) {
    val shutterIslandMovie = listMovie.firstOrNull { it.title == "Shutter Island" }

    shutterIslandMovie?.let { movie ->
        makeScreen(movie,navController)
    }
}




