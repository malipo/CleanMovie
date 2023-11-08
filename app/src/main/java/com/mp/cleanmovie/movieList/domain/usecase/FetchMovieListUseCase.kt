package com.mp.cleanmovie.movieList.domain.usecase

import com.mp.cleanmovie.movieList.domain.repository.MovieListRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class FetchMovieListUseCase @Inject constructor(
    private val movieListRepository: MovieListRepository,
) {

    suspend fun fetchMovies() = movieListRepository.getMovies()
}
