package com.simulated.presentation_home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simulated.data_movies_repository.data_sources.remote.RemoteMoviesSource
import com.simulated.data_movies_repository.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchMoviesViewModel @Inject constructor(
    private var moviesRepo: MoviesRepository,
     private var movieConverter: MovieConverter
) : ViewModel() {

    val TAG = SearchMoviesViewModel::class.java.simpleName


    fun searchMovies(page: Int, query: String) {
        viewModelScope.launch {
            moviesRepo.searchMovies(page, query)
                .map {
                    movieConverter.convert(it)
                }.collect {
                    Log.d(TAG, "searchMovies: $it")
                }
        }
    }

}