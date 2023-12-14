package com.mp.cleanmovie.movieList.data.local

import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@ViewModelScoped
class MovieListLocalDataSourceImpl @Inject constructor(
    private val movieDao: MovieDao,
) : MovieListLocalDataSource {
    override suspend fun getMovies(): Flow<MovieEntity> {
        return flow {
            val response = movieDao.getMovies()

        }
    }
}
