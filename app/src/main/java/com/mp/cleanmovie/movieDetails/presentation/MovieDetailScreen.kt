package com.mp.cleanmovie.movieDetails.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mp.cleanmovie.R

@Composable
fun MovieDetailScreen(
    movieId: String,
    navController: NavHostController,
    viewModel: MovieDetailViewModel = hiltViewModel(),
) {

    val uiState = viewModel.uiState.collectAsState()
    viewModel.submitMovieId(movieId)
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        item(key = "backdrop") {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ) {
                ImageItem(
                    modifier = Modifier.fillMaxSize(),
                    data = uiState.value.movie?.backdrop ?: R.drawable.placeholder,
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                modifier = Modifier,
                text = uiState.value.movie?.title ?: "",
                color = Color.Gray,
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                fontWeight = FontWeight.Medium
            )

            RatingBar(rating = 2) {}
        }

        item(key = "description") {
            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                    text = uiState.value.movie?.getReleasedOnYear() ?: ""
                )
                Divider(
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                )
                Text(
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                    text = uiState.value.movie?.length ?: ""
                )
                Divider(
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                )
                Text(
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                    text = uiState.value.movie?.getDirector() ?: ""
                )
            }
        }

        item(key = "cast") {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                text = uiState.value.movie?.getCast() ?: ""
            )
        }

        item(key = "overview") {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                text = uiState.value.movie?.overview ?: ""
            )
        }

    }
}

@Composable
fun RatingBar(rating: Int, onRate: (Int) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        for (i in 1..5) {
            Icon(
                imageVector = if (i <= rating) Icons.Filled.Star else Icons.Outlined.Star,
                tint = if (i <= rating) Color.Yellow else Color.Gray,
                contentDescription = "Rate $i"
            )
        }
    }
}

@Composable
fun ImageItem(
    modifier: Modifier,
    data: Any?,
    contentDescription: String = stringResource(R.string.description),
    contentScale: ContentScale = ContentScale.Crop
) {
    AsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(LocalContext.current).data(data).crossfade(true).build(),
        contentDescription = contentDescription,
        placeholder = painterResource(id = R.drawable.placeholder),
        contentScale = contentScale
    )
}
