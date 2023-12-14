package com.mp.cleanmovie.movieList.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies_table")
data class MovieEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String? = null,
    val backdrop: String? = null,
    val cast: List<String>? = null,
    val classification: String? = null,
    val director: Any? = null,
    val genres: List<String>? = null,
    val imdb_rating: Double? = null,
    val length: String? = null,
    val overview: String? = null,
    val poster: String? = null,
    val released_on: String? = null,
    val slug: String? = null,
    val title: String? = null

)