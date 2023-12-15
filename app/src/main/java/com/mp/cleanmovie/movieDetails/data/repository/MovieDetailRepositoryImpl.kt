package com.mp.cleanmovie.movieDetails.data.repository

import com.mp.cleanmovie.movieDetails.domain.repository.MovieDetailRepository
import com.mp.cleanmovie.movieList.data.local.database.MovieEntity
import com.mp.cleanmovie.movieList.data.local.MovieListLocalDataSource
import com.mp.cleanmovie.core.domain.model.DomainMovieData


import javax.inject.Inject

class MovieDetailRepositoryImpl @Inject constructor(
    private val movieListLocalDataSource: MovieListLocalDataSource,
    private val mapper: Mapper

) : MovieDetailRepository {
    override suspend fun getSelectedMovie(id: String): DomainMovieData {
        val movieEntity = movieListLocalDataSource.getSelectedMovie(id)
        return mapper.mapEntityToDomain(movieEntity)
    }
}

class Mapper @Inject constructor() {
    fun mapEntityToDomain(movieEntity: MovieEntity): DomainMovieData {
        with(movieEntity) {
            return DomainMovieData(
                id = id,
                title = title,
                backdrop = backdrop,
                classification = classification,
                director = director,
                imdb_rating = imdb_rating,
                length = length,
                overview = overview,
                poster = poster,
                released_on = released_on,
                slug = slug,
                genres = genres,
                cast = cast
            )
        }
    }
}
