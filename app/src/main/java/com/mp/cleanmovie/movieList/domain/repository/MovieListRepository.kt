package com.mp.cleanmovie.movieList.domain.repository


import com.mp.cleanmovie.core.data.model.GetMoviesResponse

import kotlinx.coroutines.flow.Flow

interface MovieListRepository {

    suspend fun getMovies(): Flow<GetMoviesResponse>

}