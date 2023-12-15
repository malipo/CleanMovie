package com.mp.cleanmovie.movieList.domain.model

data class DomainMovieData(
    val backdrop: String,
    val cast: List<String>,
    val classification: String,
    val director: Any,
    val genres: List<String>,
    val id: String,
    val imdb_rating: Double,
    val length: String,
    val overview: String,
    val poster: String,
    val released_on: String,
    val slug: String,
    val title: String
) {
    fun getTitleRate(): String {
        return "$title (IMDB:$imdb_rating)"
    }
}
