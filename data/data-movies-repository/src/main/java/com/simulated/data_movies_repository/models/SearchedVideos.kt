package com.simulated.data_movies_repository.models

data class SearchedVideos(
    var page: Int,
    var results: List<Video>,
    var totalPages: Int,
    var totalResults: Int,
)

data class Video(
    var adult: Boolean?,
    var id: Int?,
    var mediaType: String,
    var originalLanguage: String?,
    var originalTitle: String?,
    var overview: String?,
    var popularity: Float?,
    var posterPath: String?,
    var releaseDate: String?,
    var profilePath: String?,
    var title: String?,
    var video: Boolean?,
    var voteAverage: Float?,
    var voteCount: Int?,
    var firstAirDate: String?,
    var name: String?,
    var originCountry: List<String>?,
    var originalName: String?,
)
