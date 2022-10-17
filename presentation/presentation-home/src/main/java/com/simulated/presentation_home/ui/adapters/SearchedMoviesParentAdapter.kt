package com.simulated.presentation_home.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.simulated.data_movies_repository.models.Video
import com.simulated.presentation_home.databinding.ListItemMediaBinding
import com.simulated.presentation_home.databinding.ListItemMovieBinding
import com.simulated.presentation_home.databinding.ListItemSearchedMovieParentBinding
import com.simulated.presentation_home.databinding.ListItemTvBinding
import com.simulated.presentation_home.models.SearchedMoviesUi


class SearchedMoviesParentAdapter :
    ListAdapter<SearchedMoviesUi, SearchedMoviesParentAdapter.ViewHolder>(
        DIFF_CALLBACK
    ) {

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
            initMoviesRecyclerView(binding.rvMoviesImages,video.content)
        }


    }

    private fun initMoviesRecyclerView(rvMoviesImages: RecyclerView, content: List<Video>) {
        rvMoviesImages.layoutManager = LinearLayoutManager(rvMoviesImages.context,RecyclerView.HORIZONTAL,false)
        val mAdapter = SearchedMoviesChildAdapter()
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