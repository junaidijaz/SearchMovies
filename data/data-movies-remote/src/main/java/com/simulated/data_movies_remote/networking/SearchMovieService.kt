package com.simulated.data_movies_remote.networking

import retrofit2.http.GET
import retrofit2.http.Query

interface SearchMovieService {
    @GET("search/multi")
    suspend fun searchMovies(@Query("page") page: Int,@Query("query") query: String): SearchMovieApiResponse
}