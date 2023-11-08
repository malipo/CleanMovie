package com.mp.cleanmovie.movieList.data.dataSource.remote.api

import com.mp.cleanmovie.data.model.GetMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MovieListApi {


    //"Authorization: Bearer Wookie2019"
    @GET("/movies")
    suspend fun getMovies(@Header("Authorization") auth: String = "Bearer Wookie2019"): GetMoviesResponse

    @GET("movies")
    suspend fun search(@Query("q") q: String): GetMoviesResponse
}
