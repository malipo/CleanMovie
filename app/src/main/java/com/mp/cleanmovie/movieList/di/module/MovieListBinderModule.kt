package com.mp.cleanmovie.movieList.di.module

import com.mp.cleanmovie.movieList.data.local.MovieListLocalDataSource
import com.mp.cleanmovie.movieList.data.local.MovieListLocalDataSourceImpl
import com.mp.cleanmovie.movieList.data.remote.MovieListRemoteDataSource
import com.mp.cleanmovie.movieList.data.remote.MovieListRemoteDataSourceImpl
import com.mp.cleanmovie.movieList.data.repository.MovieListRepositoryImpl
import com.mp.cleanmovie.movieList.domain.repository.MovieListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class MovieListBinderModule {

    @Binds
    abstract fun bindMovieListRemoteDateSource(movieListRemoteDataSourceImpl: MovieListRemoteDataSourceImpl): MovieListRemoteDataSource

    @Binds
    abstract fun bindMovieListLocalDateSource(movieListLocalDataSourceImpl: MovieListLocalDataSourceImpl): MovieListLocalDataSource
    @Binds
    abstract fun bindMovieListRepository(movieListRepositoryImpl: MovieListRepositoryImpl): MovieListRepository
}
