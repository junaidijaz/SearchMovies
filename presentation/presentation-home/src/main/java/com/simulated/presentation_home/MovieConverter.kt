package com.simulated.presentation_home

import com.simulated.data_movies_repository.models.SearchedVideos
import com.simulated.presentation_common.state.CommonResultConverter
import com.simulated.presentation_home.models.SearchedMoviesUi
import javax.inject.Inject

class MovieConverter @Inject constructor() :
    CommonResultConverter<SearchedVideos, List<SearchedMoviesUi>>() {

    override fun convertSuccess(data: SearchedVideos): List<SearchedMoviesUi> {
        return data.results.groupBy { it.mediaType }
            .map { movie -> SearchedMoviesUi(movie.key, movie.value) }
    }
}