package com.simulated.presentation_home.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.simulated.presentation_common.base_classes.BaseFragment
import com.simulated.presentation_common.collectLatestLifeCycleFlow
import com.simulated.presentation_common.hide
import com.simulated.presentation_common.show
import com.simulated.presentation_common.state.UiState
import com.simulated.presentation_home.R
import com.simulated.presentation_home.SearchMoviesViewModel
import com.simulated.presentation_home.databinding.FragmentSearchBinding
import com.simulated.presentation_home.ui.adapters.SearchedMoviesParentAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    val TAG = SearchFragment::class.java.simpleName
    var pageNumber = 1

    private val viewModel: SearchMoviesViewModel by viewModels()

    @Inject
    lateinit var mAdapter: SearchedMoviesParentAdapter


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
        applyListeners()
    }

    private fun applyListeners() {
        binding.etSearch.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                searchMovies(binding.etSearch.text.toString().trim())
                hideSoftKeyboard(binding.etSearch)

                return@OnEditorActionListener true
            }
            false
        })
    }


    private fun hideSoftKeyboard(input: EditText) {
        val imm =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.hideSoftInputFromWindow(input.windowToken, 0)
    }

    private fun initRecyclerView() {
        binding.rvMovies.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMovies.adapter = mAdapter
        mAdapter.setItemClickListenerCallBack {
            val action = SearchFragmentDirections.actionSearchFragmentToDetailsFragment(it)
            findNavController().navigate(action)
        }
    }

    private fun searchMovies(query: String) {

        if (query.isEmpty()) {
            return
        }
        viewModel.searchMovies(pageNumber, query)
    }

    private fun applyViewModelListeners() {
        collectLatestLifeCycleFlow(viewModel.searchMoviesFlow) {
            when (it) {
                is UiState.Error -> {
                    Log.d(TAG, "onCreate: Error")
                    Toast.makeText(requireContext(), it.errorMessage, Toast.LENGTH_SHORT).show()
                    binding.pbSearchMovies.hide()
                }
                is UiState.Loading -> {
                    binding.pbSearchMovies.show()
                    Log.d(TAG, "onCreate: loading")
                }
                is UiState.Success -> {
                    binding.pbSearchMovies.hide()
                    mAdapter.submitList(it.data)
                }
            }
        }
    }

}