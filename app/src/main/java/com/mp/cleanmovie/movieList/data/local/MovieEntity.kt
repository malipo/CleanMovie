package com.mp.cleanmovie.movieList.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "movies_table")
data class MovieEntity(

    @PrimaryKey(autoGenerate = false)
    val id: String,
    val backdrop: String,
    @TypeConverters(ClassConverter::class)
    val cast: List<String>,
    val classification: String,
    @TypeConverters(ClassConverter::class)
    val director: Any,
    @TypeConverters(ClassConverter::class)
    val genres: List<String>,
    val imdb_rating: Double,
    val length: String,
    val overview: String,
    val poster: String,
    val released_on: String,
    val slug: String,
    val title: String

)

