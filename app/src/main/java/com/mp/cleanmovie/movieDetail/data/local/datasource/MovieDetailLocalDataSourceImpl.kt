package com.mp.cleanmovie.movieDetail.data.local.datasource

import com.mp.cleanmovie.movieList.data.local.database.MovieDao
import com.mp.cleanmovie.movieList.data.local.database.MovieEntity
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class MovieDetailLocalDataSourceImpl @Inject constructor(
    private val movieDao: MovieDao,
) : MovieDetailLocalDataSource {

    override suspend fun getSelectedMovie(id: String): MovieEntity {
        return movieDao.getSelectedMovie(id)
    }
}
