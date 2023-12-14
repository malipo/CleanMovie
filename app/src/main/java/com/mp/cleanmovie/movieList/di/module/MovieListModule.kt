package com.mp.cleanmovie.movieList.di.module

import com.mp.cleanmovie.movieList.data.remote.api.MovieListApi
import com.mp.cleanmovie.movieList.domain.usecase.FetchMovieDetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object MovieListModule {

    @Provides
    fun provideMovieListApi(retrofit: Retrofit): MovieListApi =
        retrofit.create(MovieListApi::class.java)

    @Provides
    fun bindMoviesUsCase(): FetchMovieDetailUseCase = FetchMovieDetailUseCase()
}
