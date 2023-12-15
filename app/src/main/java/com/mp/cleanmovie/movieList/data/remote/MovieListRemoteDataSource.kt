package com.mp.cleanmovie.movieList.data.remote

import com.mp.cleanmovie.core.data.model.GetMoviesResponse
import kotlinx.coroutines.flow.Flow

interface MovieListRemoteDataSource {
    suspend fun getMovies(): Flow<GetMoviesResponse>
}