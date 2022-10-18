package com.simulated.presentation_home.models

import android.os.Parcelable
import com.simulated.presentation_home.Constants
import kotlinx.parcelize.Parcelize


data class SearchedMoviesUi(val movieType: String, val content: List<VideoUi>)

@Parcelize
data class VideoUi(
    var id: Int?,
    var mediaType: String,
    var originalTitle: String?,
    var overview: String?,
    var posterPath: String?,
    var releaseDate: String?,
    var profilePath: String?,
    var title: String?,
    var name: String?,
    var originalName: String?,
) : Parcelable {
    val videoThumbnail get() = if (posterPath != null) Constants.imageBaseUrl + posterPath else Constants.imageBaseUrl + profilePath
    val videoLogoOriginal get() = if (posterPath != null) Constants.imageBaseUrlOriginal + posterPath else Constants.imageBaseUrlOriginal + profilePath
}

