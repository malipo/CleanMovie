package com.mp.cleanmovie.movieDetails.di

import com.mp.cleanmovie.movieDetails.data.local.datasource.MovieDetailLocalDataSource
import com.mp.cleanmovie.movieDetails.data.local.datasource.MovieDetailLocalDataSourceImpl
import com.mp.cleanmovie.movieDetails.data.repository.MovieDetailRepositoryImpl
import com.mp.cleanmovie.movieDetails.domain.repository.MovieDetailRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class MovieDetailBinderModule {

    @Binds
    abstract fun bindMovieDetailLocalDateSource(movieDetailLocalDataSourceImpl: MovieDetailLocalDataSourceImpl): MovieDetailLocalDataSource
    @Binds
    abstract fun bindMovieDetailRepository(movieDetailRepositoryImpl: MovieDetailRepositoryImpl): MovieDetailRepository
}
