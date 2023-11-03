package com.mp.cleanmovie.data.service

import com.mp.cleanmovie.data.model.GetMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

  @GET("/movies") suspend fun getMovies(): GetMoviesResponse

  @GET("movies") suspend fun search(@Query("q") q: String): GetMoviesResponse
}
