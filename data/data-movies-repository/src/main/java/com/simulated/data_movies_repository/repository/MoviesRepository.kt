package com.simulated.data_movies_repository.repository

import com.simulated.data_movies_repository.data_sources.remote.RemoteMoviesSource
import javax.inject.Inject

class MoviesRepository @Inject constructor(private var remoteConfigurationSource: RemoteMoviesSource) {

    fun searchMovies(page: Int, query: String) = remoteConfigurationSource.searchMovies(page, query)

}