package com.mp.cleanmovie.movieDetail.data.local.datasource

import com.mp.cleanmovie.movieList.data.local.database.MovieEntity

interface MovieDetailLocalDataSource {
    suspend fun getSelectedMovie(id: String): MovieEntity

}
