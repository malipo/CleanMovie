package com.mp.cleanmovie.movieList.presentation.screen

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

import com.mp.cleanmovie.movieList.presentation.viewModel.MovieDetailViewModel

@Composable
fun MovieDetailScreen(
    movieId:String,
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

        item(key = "description") {
            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {

                Text(
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                    text = uiState.value.movie?.getTitleRate() ?: "why?"
                )
            }
        }
    }
}