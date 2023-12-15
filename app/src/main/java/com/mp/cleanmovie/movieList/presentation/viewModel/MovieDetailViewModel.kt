package com.mp.cleanmovie.movieList.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mp.cleanmovie.movieList.domain.model.DomainMovieData
import com.mp.cleanmovie.movieList.domain.usecase.FetchMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val fetchMovieDetailUseCase: FetchMovieDetailUseCase,
) :
    ViewModel() {
    private val _uiState = MutableStateFlow(MovieDetailUiState())
    val uiState: StateFlow<MovieDetailUiState> = _uiState

    fun submitMovieId(id: String) {
        _uiState.update {
            it.copy(movieId = id)
        }
        Log.d("TAG", "idd: $id")
    }

    init {
        viewModelScope.launch {
            uiState.collectLatest { state ->
                state.movieId?.let {
                    fetchMovieDetail(it)
                }
            }
        }
    }

    data class MovieDetailUiState(
        val movieId: String? = null,
        var movie: DomainMovieData? = null,
    )

    private fun fetchMovieDetail(id: String) {

        viewModelScope.launch(Dispatchers.IO) {
            val movie = fetchMovieDetailUseCase.getSelectedMovie(id)
            withContext(Dispatchers.Main) {
                val newUiState = _uiState.value.copy(movie = movie)
                _uiState.value = newUiState
                Log.d("TAG", "fetchMovieDetail: $newUiState")
                _uiState.emit(newUiState)
            }
        }
    }
}
