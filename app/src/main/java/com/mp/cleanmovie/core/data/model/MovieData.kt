package com.mp.cleanmovie.core.data.model

data class MovieData(
    val backdrop: String? = null,
    val cast: List<String>? = null,
    val classification: String? = null,
    val director: Any? = null,
    val genres: List<String>? = null,
    val id: String? = null,
    val imdb_rating: Double? = null,
    val length: String? = null,
    val overview: String? = null,
    val poster: String? = null,
    val released_on: String? = null,
    val slug: String? = null,
    val title: String? = null
) {
    fun getTitleRate(): String {
        return "$title (IMDB:$imdb_rating)"
    }
}
