package com.mp.cleanmovie.data.repository.home

import com.mp.cleanmovie.data.service.ApiClient
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepositoryImp @Inject constructor(
    private val apiClient: ApiClient,
) : HomeRepository {

    override suspend fun getMovies() = flow {
        val response = apiClient.getMovies()
        emit(response)
    }


}
