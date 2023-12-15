package com.mp.cleanmovie.movieList.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mp.cleanmovie.movieList.domain.model.DomainMovieData
import com.mp.cleanmovie.movieList.domain.usecase.FetchMovieDetailUseCase
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
    private val fetchMovieDetailUseCase: FetchMovieDetailUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(MovieListUiState())
    val uiState: StateFlow<MovieListUiState> = _uiState
//    fun setMovieSelected(movieData: MovieData) {
//        fetchMovieDetailUseCase.selectedMovie.value = movieData
////        Log.d("TAG", "fetchMovieDetail: $movieData")
//    }
    init {
        fetchMovies()
    }
    data class MovieListUiState(
        val movies: List<DomainMovieData> = emptyList(),
//        var movieSelected: MovieData? = null,
    ){
        fun getMoviesByGenre(): Map<String, List<DomainMovieData>> {
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
                    val response =it
                   val newUiState = _uiState.value.copy(movies = response)

                    Log.d("TAG", "fetchMovieList: $response")
                    _uiState.emit(newUiState)
                }
        }
    }
}



// event (MVI)

// viewModel base (Wrong way)
