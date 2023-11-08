package com.mp.cleanmovie.movieList.domain.repository

import androidx.annotation.WorkerThread

import com.mp.cleanmovie.core.data.model.GetMoviesResponse

import kotlinx.coroutines.flow.Flow

interface MovieListRepository {

    @WorkerThread
    suspend fun getMovies(): Flow<GetMoviesResponse>

}