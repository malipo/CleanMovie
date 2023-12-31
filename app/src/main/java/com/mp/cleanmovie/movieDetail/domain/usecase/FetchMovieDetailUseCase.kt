package com.mp.cleanmovie.movieDetail.domain.usecase


import com.mp.cleanmovie.movieDetail.domain.repository.MovieDetailRepository
import com.mp.cleanmovie.core.domain.model.DomainMovieData
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject


@ViewModelScoped
class FetchMovieDetailUseCase @Inject constructor(
    private val movieDetailRepository: MovieDetailRepository
) {
    suspend fun getSelectedMovie(id: String): DomainMovieData {
        return movieDetailRepository.getSelectedMovie(id)
    }
}
