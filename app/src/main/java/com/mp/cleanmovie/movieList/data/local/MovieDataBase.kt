package com.mp.cleanmovie.movieList.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [MovieEntity::class],
    version = 1,
)
abstract class MovieDataBase : RoomDatabase() {
    abstract val dao: MovieDao
}