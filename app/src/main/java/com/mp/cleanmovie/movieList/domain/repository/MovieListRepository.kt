package com.mp.cleanmovie.movieList.domain.repository


import com.mp.cleanmovie.core.domain.model.DomainMovieData

import kotlinx.coroutines.flow.Flow

interface MovieListRepository {

    suspend fun getMovies(): Flow<List<DomainMovieData>>
    suspend fun getSelectedMovie(id:String): DomainMovieData

}