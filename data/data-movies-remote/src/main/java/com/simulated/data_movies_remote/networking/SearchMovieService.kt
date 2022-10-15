package com.simulated.data_movies_remote.networking

import retrofit2.http.GET

interface SearchMovieService {
    @GET("search/multi")
    suspend fun searchMovies(page: Int, query: String): SearchMovieApiResponse
}