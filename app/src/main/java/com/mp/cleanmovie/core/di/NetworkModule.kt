package com.mp.cleanmovie.core.di

import com.mp.cleanmovie.core.Consts
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    @Named(Consts.RATES_API)
    fun provideRatesUrl() = Consts.RATES_API

    @Provides
    @Singleton
    fun provideKotlinJsonAdapterFactory(): KotlinJsonAdapterFactory = KotlinJsonAdapterFactory()

    @Provides
    @Singleton
    fun provideMoshi(kotlinJsonAdapterFactory: KotlinJsonAdapterFactory): Moshi = Moshi.Builder()
        .add(kotlinJsonAdapterFactory)
        .build()

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory =
        MoshiConverterFactory.create(moshi)

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitClient(
        okHttp: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory,
        @Named(Consts.RATES_API) url: String,
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(moshiConverterFactory)
//        .addCallAdapterFactory(CallAdapterFactory.create())
        .client(okHttp)
        .baseUrl(url)
        .build()

//    @Provides
//    @Singleton
//    fun provideApiService(retrofit: Retrofit): MovieListApi {
//        return retrofit.create(MovieListApi::class.java)
//    }
//
//    // TODO we should have ApiClient ?
//    @Provides
//    @Singleton
//    fun provideApiClient(movieListApi: MovieListApi): ApiClient {
//        return ApiClient(movieListApi)
//    }
}
