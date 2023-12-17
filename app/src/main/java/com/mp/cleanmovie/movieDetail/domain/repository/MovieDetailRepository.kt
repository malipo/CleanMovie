package com.mp.cleanmovie.movieDetail.domain.repository

import com.mp.cleanmovie.core.domain.model.DomainMovieData


interface MovieDetailRepository {

    suspend fun getSelectedMovie(id:String): DomainMovieData

}