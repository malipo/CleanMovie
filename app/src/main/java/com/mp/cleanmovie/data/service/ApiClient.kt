package com.mp.cleanmovie.data.service

import com.mp.cleanmovie.data.model.GetMoviesResponse
import javax.inject.Inject

class ApiClient @Inject constructor(private val apiService: ApiService) {

    suspend fun getMovies(): GetMoviesResponse =
        apiService.getMovies()

    suspend fun search(query:String): GetMoviesResponse =
        apiService.search(query)

}
