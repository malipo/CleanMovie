package com.mp.cleanmovie.movieList.data.local

import com.mp.cleanmovie.movieList.data.local.database.MovieDao
import com.mp.cleanmovie.movieList.data.local.database.MovieEntity
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
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
