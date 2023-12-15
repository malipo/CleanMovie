package com.mp.cleanmovie.movieList.data.local.database

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi

class ClassConverter {

    @TypeConverter
    fun fromGenres(genres: List<String>): String {
        return genres.joinToString(",")
    }

    @TypeConverter
    fun toGenres(genresString: String): List<String> {
        return genresString.split(",").map { it }
    }

    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun toString(value: Any): String {
        return moshi.adapter(Any::class.java).toJson(value)
    }

    @TypeConverter
    fun toAny(value: String): Any {
        return moshi.adapter(Any::class.java).fromJson(value)!!
    }
}