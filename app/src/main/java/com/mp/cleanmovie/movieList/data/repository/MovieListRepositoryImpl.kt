package com.mp.cleanmovie.movieList.data.repository

import com.mp.cleanmovie.core.data.model.MovieData
import com.mp.cleanmovie.movieList.data.local.MovieEntity
import com.mp.cleanmovie.movieList.data.local.MovieListLocalDataSource
import com.mp.cleanmovie.movieList.data.remote.MovieListRemoteDataSource
import com.mp.cleanmovie.movieList.domain.model.DomainMovieData
import com.mp.cleanmovie.movieList.domain.repository.MovieListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map

import javax.inject.Inject

class MovieListRepositoryImpl @Inject constructor(
    private val movieListRemoteDataSource: MovieListRemoteDataSource,
    private val movieListLocalDataSource: MovieListLocalDataSource,
    private val mapper: Mapper

) : MovieListRepository {
    override suspend fun getMovies(): Flow<List<DomainMovieData>> {
        movieListRemoteDataSource.getMovies().collectLatest { remoteData ->
            val mappedEntities = mapper.mapMovieDataListToMovieEntityList(remoteData.movies)
            movieListLocalDataSource.insertMovies(mappedEntities)
        }
        return movieListLocalDataSource.getMovies().map {
            mapper.mapEntityListToDomainList(it)
        }
    }

    override suspend fun getSelectedMovie(id: String): DomainMovieData {
        val movieEntity = movieListLocalDataSource.getSelectedMovie(id)
        return mapper.mapEntityToDomain(movieEntity)
    }
}

class Mapper @Inject constructor() {
    fun mapMovieDataListToMovieEntityList(movieData: List<MovieData>): List<MovieEntity> {
        return movieData.map {
            with(it) {
                MovieEntity(
                    id = id!!,
                    title = title!!,
                    backdrop = backdrop!!,
                    classification = classification!!,
                    director = director!!,
                    imdb_rating = imdb_rating!!,
                    length = length!!,
                    overview = overview!!,
                    poster = poster!!,
                    released_on = released_on!!,
                    slug = slug!!,
                    genres = genres!!,
                    cast = cast!!
                )
            }
        }
    }


    fun mapEntityListToDomainList(movieEntity: List<MovieEntity>): List<DomainMovieData> {
        return movieEntity.map {
            with(it) {
                DomainMovieData(
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
