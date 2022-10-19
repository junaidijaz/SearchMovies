package com.simulated.presentation_home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simulated.data_common.entity.Result
import com.simulated.data_movies_repository.repository.MoviesRepository
import com.simulated.presentation_common.state.UiState
import com.simulated.presentation_home.models.SearchedMoviesUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchMoviesViewModel @Inject constructor(
    private var moviesRepo: MoviesRepository,
    private var movieConverter: MovieConverter
) : ViewModel() {

    private val _searchMoviesFlow =
        MutableStateFlow<UiState<List<SearchedMoviesUi>>>(UiState.Success(emptyList()))
    val searchMoviesFlow: StateFlow<UiState<List<SearchedMoviesUi>>> = _searchMoviesFlow

    fun searchMovies(page: Int, query: String) {
        _searchMoviesFlow.value = UiState.Loading
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