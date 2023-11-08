package com.mp.cleanmovie.data.service

import com.mp.cleanmovie.data.model.GetMoviesResponse
import com.mp.cleanmovie.movieList.data.dataSource.remote.api.MovieListApi
import javax.inject.Inject

class ApiClient @Inject constructor(private val movieListApi: MovieListApi) {

    suspend fun getMovies(): GetMoviesResponse =
        movieListApi.getMovies()

    suspend fun search(query:String): GetMoviesResponse =
        movieListApi.search(query)

}
