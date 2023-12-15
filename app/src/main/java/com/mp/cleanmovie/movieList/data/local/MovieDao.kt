package com.mp.cleanmovie.movieList.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Upsert
    suspend fun insertMovies(movies: List<MovieEntity>)

    @Query("SELECT * FROM movies_table")
    fun getMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movies_table WHERE id = :id")
    fun getSelectedMovie(id: String): MovieEntity

}