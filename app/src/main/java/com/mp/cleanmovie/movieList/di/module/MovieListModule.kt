package com.mp.cleanmovie.movieList.di.module

import com.mp.cleanmovie.movieList.data.dataSource.remote.api.MovieListApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object MovieListModule {

    @Provides
    fun provideMovieListApi(retrofit: Retrofit): MovieListApi =
        retrofit.create(MovieListApi::class.java)
}
