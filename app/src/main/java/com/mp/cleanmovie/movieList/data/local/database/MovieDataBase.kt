package com.mp.cleanmovie.movieList.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@TypeConverters(ClassConverter::class)
@Database(
    entities = [MovieEntity::class],
    version = 1,
)
abstract class MovieDataBase : RoomDatabase() {
    abstract val dao: MovieDao
}