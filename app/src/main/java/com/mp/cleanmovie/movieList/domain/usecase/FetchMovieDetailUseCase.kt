package com.mp.cleanmovie.movieList.domain.usecase

import androidx.compose.runtime.mutableStateOf
import com.mp.cleanmovie.core.data.model.MovieData
import dagger.hilt.android.scopes.ViewModelScoped


@ViewModelScoped
class FetchMovieDetailUseCase (){
    val selectedMovie = mutableStateOf<MovieData?>(null)
}
