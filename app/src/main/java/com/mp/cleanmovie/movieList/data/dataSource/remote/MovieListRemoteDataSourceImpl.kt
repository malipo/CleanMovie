package com.mp.cleanmovie.movieList.data.dataSource.remote

import com.mp.cleanmovie.core.data.model.GetMoviesResponse
import com.mp.cleanmovie.movieList.data.dataSource.remote.api.MovieListApi
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@ViewModelScoped
class MovieListRemoteDataSourceImpl @Inject constructor(
    private val movieListApi: MovieListApi,
) : MovieListRemoteDataSource {
    override suspend fun getMovies(): Flow<GetMoviesResponse> {
        return flow {
            val response = movieListApi.getMovies()
            emit(response)
        }
    }
}
