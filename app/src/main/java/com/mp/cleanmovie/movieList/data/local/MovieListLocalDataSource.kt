package com.mp.cleanmovie.movieList.data.local

import com.mp.cleanmovie.movieList.data.local.database.MovieEntity
import kotlinx.coroutines.flow.Flow

interface MovieListLocalDataSource {
    suspend fun getMovies(): Flow<List<MovieEntity>>
    suspend fun insertMovies(list: List<MovieEntity>)
    suspend fun getSelectedMovie(id: String): MovieEntity

}
