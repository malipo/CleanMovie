package com.mp.cleanmovie.movieList.data.local

import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@ViewModelScoped
class MovieListLocalDataSourceImpl @Inject constructor(
    private val movieDao: MovieDao,
) : MovieListLocalDataSource {
    override suspend fun getMovies(): Flow<List<MovieEntity>> {
        return movieDao.getMovies()

    }

    override suspend fun insertMovies(list: List<MovieEntity>) {
        movieDao.insertMovies(list)
    }

    override suspend fun getSelectedMovie(id: String): MovieEntity {
        return movieDao.getSelectedMovie(id)
    }
}
