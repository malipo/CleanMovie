package com.mp.cleanmovie.movieList.data.repository

import com.mp.cleanmovie.movieList.data.dataSource.remote.MovieListRemoteDataSource
import com.mp.cleanmovie.movieList.domain.repository.MovieListRepository
import javax.inject.Inject

class MovieListRepositoryImpl @Inject constructor(
    private val movieListRemoteDataSource: MovieListRemoteDataSource,
) : MovieListRepository {

    override suspend fun getMovies() = movieListRemoteDataSource.getMovies()
}
