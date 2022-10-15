package com.simulated.data_movies_repository.data_sources.remote

import com.simulated.data_movies_repository.models.SearchedVideos
import kotlinx.coroutines.flow.Flow

interface RemoteMoviesSource {

    fun searchMovies(page: Int, query: String): Flow<SearchedVideos>

}
