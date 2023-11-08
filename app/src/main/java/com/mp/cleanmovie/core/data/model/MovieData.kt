package com.mp.cleanmovie.core.data.model

data class MovieData(
    var backdrop: String? = null,
    var cast: List<String>? = null,
    var classification: String? = null,
    var director: Any? = null,
    var genres: List<String>? = null,
    var id: String? = null,
    var imdb_rating: Double? = null,
    var length: String? = null,
    var overview: String? = null,
    var poster: String? = null,
    var released_on: String? = null,
    var slug: String? = null,
    var title: String? = null
)

