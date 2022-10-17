package com.simulated.presentation_home.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.simulated.presentation_common.base_classes.BaseFragment
import com.simulated.presentation_common.collectLatestLifeCycleFlow
import com.simulated.presentation_common.hide
import com.simulated.presentation_common.show
import com.simulated.presentation_common.state.UiState
import com.simulated.presentation_home.SearchMoviesViewModel
 import com.simulated.presentation_home.databinding.FragmentSearchBinding
import com.simulated.presentation_home.ui.adapters.SearchedMoviesParentAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    val TAG = SearchFragment::class.java.simpleName

    private val viewModel: SearchMoviesViewModel by viewModels()
    private val mAdapter = SearchedMoviesParentAdapter()


    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSearchBinding {
        return FragmentSearchBinding.inflate(layoutInflater)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initRecyclerView()
        applyViewModelListeners()
        searchMovies("Jobs")
    }

    private fun initRecyclerView() {
        binding.rvMovies.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMovies.adapter = mAdapter
    }

    private fun searchMovies(query : String){
        viewModel.searchMovies(1, query)

    }

    private fun applyViewModelListeners() {
        collectLatestLifeCycleFlow(viewModel.searchMoviesFlow) {
            when (it) {
                is UiState.Error -> {
                    Log.d(TAG, "onCreate: Error")
                    binding.pbSearchMovies.hide()
                }
                is UiState.Loading -> {
                    binding.pbSearchMovies.show()
                    Log.d(TAG, "onCreate: loading")
                }
                is UiState.Success -> {
                    binding.pbSearchMovies.hide()
                    mAdapter.submitList(it.data)
                    Log.d(TAG,"onCreate: ${it.data}")
                }
            }
        }
    }

}