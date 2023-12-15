package com.mp.cleanmovie.movieList.domain.usecase


import com.mp.cleanmovie.movieList.domain.model.DomainMovieData
import com.mp.cleanmovie.movieList.domain.repository.MovieListRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject


@ViewModelScoped
class FetchMovieDetailUseCase @Inject constructor(
    private val movieListRepository: MovieListRepository
) {
    suspend fun getSelectedMovie(id: String): DomainMovieData {
        return movieListRepository.getSelectedMovie(id)
    }

    //val selectedMovie = mutableStateOf<DomainMovieData?>(null)
}
