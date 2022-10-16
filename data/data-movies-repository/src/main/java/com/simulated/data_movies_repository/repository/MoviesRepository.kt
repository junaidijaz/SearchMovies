package com.simulated.data_movies_repository.repository
import android.util.Log
import com.simulated.data_common.entity.AppException
import com.simulated.data_common.entity.Result
import com.simulated.data_movies_repository.data_sources.remote.RemoteMoviesSource
import com.simulated.data_movies_repository.models.SearchedVideos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class MoviesRepository @Inject constructor(private var remoteConfigurationSource: RemoteMoviesSource) {

    val TAG = MoviesRepository::class.java.simpleName
    fun searchMovies(page: Int, query: String) = remoteConfigurationSource.searchMovies(page, query)
        .map {
            Log.d(TAG, "searchMovies: ")
            Result.Success(it) as Result<SearchedVideos>
        }.flowOn(Dispatchers.IO)
        .catch {
            emit(Result.Error(AppException.createFromThrowable(it)))
        }


}