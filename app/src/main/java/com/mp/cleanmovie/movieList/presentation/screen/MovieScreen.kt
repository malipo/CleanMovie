package com.mp.cleanmovie.movieList.presentation.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mp.cleanmovie.core.data.model.MovieData
import com.mp.cleanmovie.movieList.presentation.viewModel.MovieListViewModel
import com.mp.cleanmovie.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieScreen(viewModel: MovieListViewModel = hiltViewModel(),
            ) {
    val uiState = viewModel.uiState.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text(stringResource(R.string.home_title)) }) },
        content = { innerPadding ->
            LazyColumn(
                modifier = Modifier.fillMaxSize().background(Color(194, 194, 194, 255)).padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                val moviesData = uiState.value.getMoviesByGenre()
                val genres = moviesData.keys.toList()

                items(genres.count()) { index ->
                    val genre = genres[index]
                    val movies = moviesData[genre]!!
                    GenreItem(
                        genre,
                        movies,
                        onClickMovie = { movie ->
//ToDo
                        })
                }
            }
        })
}

@Composable
private fun GenreItem(
    title: String,
    movies: List<MovieData>,
    onClickMovie: (movie: MovieData) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center)) {
        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = title,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            fontWeight = FontWeight.Bold)
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
        ) {
            items(movies.count()) { item ->
                MovieItem(
                    movie = movies[item],
                    onClickMovie = onClickMovie,
                )
            }
        }
    }
}

@Composable
private fun MovieItem(
    movie: MovieData,
    onClickMovie: (movie: MovieData) -> Unit,
) {
    Column(
        modifier = Modifier.padding(10.dp).clickable { onClickMovie(movie) },
    ) {
        Box(
            modifier =
            Modifier.size(width = 100.dp, height = 100.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model =
                ImageRequest.Builder(LocalContext.current)
                    .data(movie.poster)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.placeholder),
                contentDescription = stringResource(R.string.description),
                contentScale = ContentScale.Crop,
                modifier = Modifier.width(100.dp).height(150.dp)
            )
        }
        Text(
            modifier = Modifier.width(100.dp).padding(top = 5.dp),
            textAlign = TextAlign.Center,
            text = movie.title ?: "",
            maxLines = 1,
            fontSize = MaterialTheme.typography.labelSmall.fontSize,
            fontWeight = FontWeight.Normal
        )
    }
}