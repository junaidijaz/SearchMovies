package com.simulated.data_movies_remote.networking

import com.squareup.moshi.Json

data class SearchMovieApiResponse(
    @Json(name = "page")
    var page: Int,
    @Json(name = "results")
    var results: List<Videos>,
    @Json(name = "total_pages")
    var totalPages: Int,
    @Json(name = "total_results")
    var totalResults: Int
)

data class Videos(
    @Json(name = "adult")
    var adult: Boolean?,
    @Json(name = "backdrop_path")
    var backdropPath: String?,
    @Json(name = "genre_ids")
    var genreIds: List<Int>?,
    @Json(name = "id")
    var id: Int?,
    @Json(name = "media_type")
    var mediaType: String,
    @Json(name = "original_language")
    var originalLanguage: String?,
    @Json(name = "original_title")
    var originalTitle: String?,
    @Json(name = "overview")
    var overview: String?,
    @Json(name = "popularity")
    var popularity: Float?,
    @Json(name = "poster_path")
    var posterPath: String?,
    @Json(name = "profile_path")
    var profilePath: String?,
    @Json(name = "release_date")
    var releaseDate: String?,
    @Json(name = "title")
    var title: String?,
    @Json(name = "video")
    var video: Boolean?,
    @Json(name = "vote_average")
    var voteAverage: Float?,
    @Json(name = "vote_count")
    var voteCount: Int?,
    @Json(name = "first_air_date")
    var firstAirDate: String?,
    @Json(name = "name")
    var name: String?,
    @Json(name = "origin_country")
    var originCountry: List<String>?,
    @Json(name = "original_name")
    var originalName: String?
)

