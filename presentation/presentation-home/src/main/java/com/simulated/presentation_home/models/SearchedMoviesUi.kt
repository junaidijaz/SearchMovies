package com.simulated.presentation_home.models

import com.simulated.data_movies_repository.models.Video


data class SearchedMoviesUi(val movieType: String, val content: List<Video>)

