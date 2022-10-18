package com.simulated.presentation_home.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.simulated.presentation_home.databinding.ListItemSearchedMovieParentBinding
import com.simulated.presentation_home.models.SearchedMoviesUi
import com.simulated.presentation_home.models.VideoUi
import javax.inject.Inject


class SearchedMoviesParentAdapter @Inject constructor() :
    ListAdapter<SearchedMoviesUi, SearchedMoviesParentAdapter.ViewHolder>(
        DIFF_CALLBACK
    ) {


    private var mListener: ((VideoUi) -> Unit)? = null

    fun setItemClickListenerCallBack(listener: (VideoUi) -> Unit) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ListItemSearchedMovieParentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class ViewHolder(private var binding: ListItemSearchedMovieParentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            video: SearchedMoviesUi
        ) {
            binding.tvMovieType.text = video.movieType
            initMoviesRecyclerView(binding.rvMoviesImages, video.content)
        }


    }

    private fun initMoviesRecyclerView(rvMoviesImages: RecyclerView, content: List<VideoUi>) {
        rvMoviesImages.layoutManager =
            LinearLayoutManager(rvMoviesImages.context, RecyclerView.HORIZONTAL, false)
        val mAdapter = SearchedMoviesChildAdapter(rvMoviesImages.context,mListener)
        rvMoviesImages.adapter = mAdapter
        mAdapter.submitList(content)

    }


    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<SearchedMoviesUi>() {
                override fun areItemsTheSame(
                    oldItem: SearchedMoviesUi,
                    newItem: SearchedMoviesUi
                ): Boolean =
                    oldItem.movieType == newItem.movieType

                override fun areContentsTheSame(
                    oldItem: SearchedMoviesUi,
                    newItem: SearchedMoviesUi
                ): Boolean =
                    oldItem == newItem
            }
    }


}