package com.mp.cleanmovie.data.repository.home

import androidx.annotation.WorkerThread

import com.mp.cleanmovie.data.model.GetMoviesResponse

import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    @WorkerThread
    suspend fun getMovies(): Flow<GetMoviesResponse>

}