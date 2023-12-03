package com.mp.cleanmovie.movieList.presentation.screen

import android.content.ClipData.Item
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mp.cleanmovie.movieList.presentation.viewModel.MovieListViewModel

@Composable
fun MovieScreen(viewModel: MovieListViewModel = hiltViewModel()) {
    val uiState = viewModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(uiState.value.result) { movie ->
                Text(text = movie.title ?: "")
            }
        }
    }
}
