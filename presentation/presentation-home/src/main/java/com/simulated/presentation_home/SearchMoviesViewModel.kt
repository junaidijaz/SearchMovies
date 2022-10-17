package com.simulated.presentation_home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simulated.data_movies_repository.data_sources.remote.RemoteMoviesSource
import com.simulated.data_movies_repository.models.Video
import com.simulated.data_movies_repository.repository.MoviesRepository
import com.simulated.presentation_common.state.UiState
import com.simulated.presentation_home.models.SearchedMoviesUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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

    private val _searchMoviesFlow =
        MutableStateFlow<UiState<List<SearchedMoviesUi>>>(UiState.Loading)
    val searchMoviesFlow: StateFlow<UiState<List<SearchedMoviesUi>>> = _searchMoviesFlow



    fun searchMovies(page: Int, query: String) {
        viewModelScope.launch {
            moviesRepo.searchMovies(page, query)
                .map {
                    movieConverter.convert(it)
                }.collect {
                    _searchMoviesFlow.value = it
                }
        }
    }

}