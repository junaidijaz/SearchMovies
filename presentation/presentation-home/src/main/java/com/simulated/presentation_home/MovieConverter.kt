package com.simulated.presentation_home

import com.simulated.data_movies_repository.models.SearchedVideos
import com.simulated.presentation_common.state.CommonResultConverter
import javax.inject.Inject

class MovieConverter @Inject constructor() :
    CommonResultConverter<SearchedVideos, List<VideoModel>>() {

    override fun convertSuccess(data: SearchedVideos): List<VideoModel> {
        return data.results.map {
            VideoModel(
                it.adult,
                it.id,
                it.mediaType,
                it.originalLanguage,
                it.originalTitle,
                it.overview,
                it.popularity,
                it.posterPath,
                it.releaseDate,
                it.title,
                it.video,
                it.voteAverage,
                it.voteCount,
                it.firstAirDate,
                it.name,
                it.originCountry,
                it.originalName
            )
        }
    }
}