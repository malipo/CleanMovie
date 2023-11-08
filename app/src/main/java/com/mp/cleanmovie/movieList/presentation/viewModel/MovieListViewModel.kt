package com.mp.cleanmovie.movieList.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mp.cleanmovie.data.model.MovieData
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

    private fun fetchMovies() {
        viewModelScope.launch {
            fetchMovieListUseCase
                .fetchMovies()
                .catch { throw it }
                .collectLatest {
                    val response = it.movies
                    val newUiState = _uiState.value.copy(result = response)
                    _uiState.emit(newUiState)
                }
        }
    }
}

data class MovieListUiState(
    val result: List<MovieData> = emptyList(),
)

// event (MVI)

// viewModel base (Wrong way)
