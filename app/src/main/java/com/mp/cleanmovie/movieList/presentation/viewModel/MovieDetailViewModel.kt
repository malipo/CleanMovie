package com.mp.cleanmovie.movieList.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mp.cleanmovie.core.data.model.MovieData
import com.mp.cleanmovie.movieList.domain.usecase.FetchMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val fetchMovieDetailUseCase: FetchMovieDetailUseCase,
) :
    ViewModel() {
    private val _uiState = MutableStateFlow(MovieDetailUiState())
    val uiState: StateFlow<MovieDetailUiState> = _uiState

    init {
        movieDetail()
    }

    data class MovieDetailUiState(
        var movie: MovieData? = null,
    )

    fun movieDetail() {
        viewModelScope.launch {

            val newUiState =
                _uiState.value.copy(movie = fetchMovieDetailUseCase.selectedMovie.value)

            Log.d("TAG", "fetchMovieDetail: $newUiState")

            _uiState.emit(newUiState)

        }
    }

}
