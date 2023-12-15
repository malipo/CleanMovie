package com.mp.cleanmovie.core.di
import android.content.Context
import androidx.room.Room
import com.mp.cleanmovie.movieList.data.local.MovieDao
import com.mp.cleanmovie.movieList.data.local.MovieDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
 object LocalModule {
        @Provides
        @Singleton
        fun provideDatabase(
            @ApplicationContext context: Context
        ): MovieDataBase {
            return Room.databaseBuilder(context, MovieDataBase::class.java, "movie_database.db").build()

    }
    @Provides
    fun provideMovieDao(movieDataBase: MovieDataBase): MovieDao {
        return movieDataBase.dao
    }
}