package com.mp.cleanmovie.movieList.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mp.cleanmovie.core.data.model.MovieData
import com.mp.cleanmovie.movieList.domain.usecase.FetchMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val fetchMovieListUseCase: FetchMovieListUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(MovieListUiState())
    val uiState: StateFlow<MovieListUiState> = _uiState

    init {
        fetchMovies()
    }
    data class MovieListUiState(
        val movies: List<MovieData> = emptyList(),
    ){
        fun getMoviesByGenre(): Map<String, List<MovieData>> {
            val genres = movies.flatMap { it.genres!! }.distinct().sortedBy { it }
            return genres.associateWith { genre ->
                movies.filter { it.genres!!.contains(genre) }.sortedBy { it.title }
            }
        }
    }
    private fun fetchMovies() {
        viewModelScope.launch {
            fetchMovieListUseCase
                .fetchMovies()
                .catch { throw it }
                .collectLatest {
                    val response = it.movies
                    val newUiState = _uiState.value.copy(movies = response)

                    Log.d("TAG", "fetchMovies: $newUiState")
                    _uiState.emit(newUiState)
                }
        }
    }
}



// event (MVI)

// viewModel base (Wrong way)
