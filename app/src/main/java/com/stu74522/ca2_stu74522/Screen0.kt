package com.stu74522.ca2_stu74522

import androidx.compose.foundation.layout.Column

import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*


import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlin.random.Random

val listMovie = listOf<Movie>(
    Movie(title = "Shutter Island", image = R.drawable.shutterisland,
        description = "Teddy Daniels and Chuck Aule, two US marshals, are sent to an asylum on a" +
                " remote island in order to investigate the disappearance of a patient, where " +
                "Teddy uncovers a shocking truth about the place.",
        starring = listOf("Leonardo DiCaprio", "Mark Ruffalo"),
        runningTimeMins = 138, seatsRemaining = Random.nextInt(16)
    )
    ,
    Movie(
        title = "Snatch",
        image = R.drawable.snatch,
        description = "Unscrupulous boxing promoters, violent bookmakers, a Russian gangster, incompetent amateur robbers, and supposedly Jewish jewelers fight to track down a priceless stolen diamond.",
        starring = listOf("Jason Statham", "Brad Pitt", "Benicio del Toro"),
        runningTimeMins = 104,
        seatsRemaining = Random.nextInt(16)
    )
    ,
    Movie(
        title = "Taxi Driver",
        image = R.drawable.taxidriver,
        description = "A mentally unstable veteran works as a nighttime taxi driver in New York City, where the perceived decadence and sleaze fuels his urge for violent action, while attempting to liberate a twelve-year-old prostitute.",
        starring = listOf("Robert De Niro", "Jodie Foster", "Cybill Shepherd"),
        runningTimeMins = 113,
        seatsRemaining = Random.nextInt(16)
    )
    ,
    Movie(
        title = "Pulp Fiction",
        image = R.drawable.pulpfiction,
        description = "The lives of two mob hitmen, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
        starring = listOf("John Travolta", "Uma Thurman", "Samuel L. Jackson"),
        runningTimeMins = 154,
        seatsRemaining = Random.nextInt(16)
    )

)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen0(navController: NavController) {
    val darkPurple = Color(0xFF00203F)
    val lightPurple = Color(0xFFADEFD1)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Home Page",
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = darkPurple,
                    titleContentColor = Color.White
                )
            )
        },

        containerColor = lightPurple
    ) { paddingValues ->
        MovieGallery(movies = listMovie, navController, modifier = Modifier.padding(paddingValues))
    }
}
@Composable
fun MovieGallery(movies: List<Movie>, navController: NavController?, modifier: Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        movies.chunked(2).forEach { rowMovies ->
            Row(modifier = Modifier.fillMaxWidth()) {
                rowMovies.forEach { movie ->
                    MovieItem(movie, navController, Modifier.weight(1f).padding(4.dp))
                }
            }
        }
        Text(
            "Data from Rotten Tomatoes",
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

    }
}



@Composable
fun MovieItem(movie: Movie, navController: NavController?, modifier: Modifier) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(8.dp)
            .background(Color(0xFFF5F5DC))
            .padding(8.dp)
    ) {
        Text(
            text = movie.title,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Image(
            painter = painterResource(id = movie.image),
            contentDescription = "${movie.title} poster",
            modifier = Modifier
                .aspectRatio(0.75f)
                .fillMaxWidth()
                .clickable {
                    navController?.navigate("details/${movie.title.replace(" ", "")}")
                }
        )
        Text(
            text = "Seats Remaining: ${movie.seatsRemaining}",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

