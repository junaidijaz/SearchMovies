package com.simulated.data_movies_remote.source

import com.simulated.data_movies_remote.networking.SearchMovieApiResponse
import com.simulated.data_movies_remote.networking.SearchMovieService
import com.simulated.data_movies_remote.networking.Videos
import com.simulated.data_movies_repository.data_sources.remote.RemoteMoviesSource
import com.simulated.data_movies_repository.models.SearchedVideos
import com.simulated.data_movies_repository.models.Video
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteMoviesSourceImp @Inject constructor(var serMoviesService: SearchMovieService) :
    RemoteMoviesSource {


    override fun searchMovies(page: Int, query: String): Flow<SearchedVideos> = flow {
        emit(serMoviesService.searchMovies(page, query))
    }.map {
        convert(it)
    }.catch {
        //todo catch exception
    }

    private fun convert(item: SearchMovieApiResponse): SearchedVideos {
        return SearchedVideos(
            item.page,
            convertVideoList(item.results),
            item.totalPages,
            item.totalResults
        )
    }

    private fun convertVideoList(list: ArrayList<Videos>): List<Video> {
        return list.map {
            Video(
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
                it.firstAirDate, it.name,
                it.originCountry,
                it.originalName
            )
        }
    }
}