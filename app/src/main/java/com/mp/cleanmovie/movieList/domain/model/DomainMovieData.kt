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
    fun getCast(): String {
        var casts = "Casts: "
        cast?.forEach { casts += "$it, " }
        return casts
    }
    fun getGenre(): String {
        var genre = "Genres: "
        genres?.forEach { genre += "$it, " }
        return genre
    }
    fun getDirector(): String {
        var _director = ""
        when (this.director) {
            is String -> _director = "Director: ${this.director as String}"
            is List<*> -> {
                _director = "Directors: "
                (this.director as List<*>).forEach { _director += "${it.toString()}, " }
            }
        }

        return _director
    }

    fun getReleasedOnYear(): String {
        var year = ""
        if (released_on == null) return year
        year = released_on!!.split("-")[0]
        return year
    }
}
