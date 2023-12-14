package com.mp.cleanmovie.movieList.data.local

import kotlinx.coroutines.flow.Flow

interface MovieListLocalDataSource {
    suspend fun getMovies(): Flow<MovieEntity>


}
