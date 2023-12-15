package com.mp.cleanmovie.movieList.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import retrofit2.Converter

@TypeConverters(ClassConverter::class)
@Database(
    entities = [MovieEntity::class],
    version = 1,
)
abstract class MovieDataBase : RoomDatabase() {
    abstract val dao: MovieDao
}