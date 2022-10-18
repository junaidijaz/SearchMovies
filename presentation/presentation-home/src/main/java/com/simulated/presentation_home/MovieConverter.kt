package com.simulated.presentation_home

import com.simulated.data_movies_repository.models.SearchedVideos
import com.simulated.data_movies_repository.models.Video
import com.simulated.presentation_common.state.CommonResultConverter
import com.simulated.presentation_home.models.SearchedMoviesUi
import com.simulated.presentation_home.models.VideoUi
import javax.inject.Inject

class MovieConverter @Inject constructor() :
    CommonResultConverter<SearchedVideos, List<SearchedMoviesUi>>() {

    override fun convertSuccess(data: SearchedVideos): List<SearchedMoviesUi> {
        return data.results.groupBy { it.mediaType }
            .map { movie -> SearchedMoviesUi(movie.key, convertVideoToUi(movie.value)) }
            .sortedBy { it.movieType }
    }

    private fun convertVideoToUi(list: List<Video>): List<VideoUi> {
        return list.map {
            VideoUi(
                it.id,
                it.mediaType,
                it.originalTitle,
                it.overview,
                it.posterPath,
                it.releaseDate,
                it.profilePath,
                it.title,
                it.name,
                it.originalName
            )
        }
    }


}