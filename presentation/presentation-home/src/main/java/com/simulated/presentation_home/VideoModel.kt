package com.simulated.presentation_home

data class VideoModel(
    var adult: Boolean?,
    var id: Int?,
    var mediaType: String,
    var originalLanguage: String?,
    var originalTitle: String?,
    var overview: String?,
    var popularity: Float?,
    var posterPath: String?,
    var releaseDate: String?,
    var title: String?,
    var video: Boolean?,
    var voteAverage: Float?,
    var voteCount: Int?,
    var firstAirDate: String?,
    var name: String?,
    var originCountry: List<String>?,
    var originalName: String?,
)
