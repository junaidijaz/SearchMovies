package com.simulated.presentation_home.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.simulated.data_movies_repository.models.Video
import com.simulated.presentation_home.databinding.ListItemMediaBinding
import com.simulated.presentation_home.databinding.ListItemMovieBinding
import com.simulated.presentation_home.databinding.ListItemSearchedMovieParentBinding
import com.simulated.presentation_home.databinding.ListItemTvBinding
import com.simulated.presentation_home.models.SearchedMoviesUi


class SearchedMoviesChildAdapter :
    ListAdapter<Video, SearchedMoviesChildAdapter.MyViewHolder>(
        DIFF_CALLBACK
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        return when (viewType) {
            MediaTypes.TV.value -> {
                TvViewHolder(
                    ListItemTvBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            MediaTypes.MOVIE.value -> {
                MovieViewHolder(
                    ListItemMovieBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> {
                MediaViewHolder(
                    ListItemMediaBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }


        }
    }


    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).mediaType) {
            "video" -> {
                MediaTypes.MOVIE.value
            }
            "tv" -> {
                MediaTypes.TV.value
            }
            else -> {
                MediaTypes.OTHER.value
            }
        }
    }

    inner class MovieViewHolder(private var binding: ListItemMovieBinding) :
        MyViewHolder(binding.root) {
        override fun bind(video: Video) {
            Glide.with(binding.root.context).load(video.videoThumbnail).into(binding.ivMovie)
        }
    }

    inner class TvViewHolder(private var binding: ListItemTvBinding) :
        MyViewHolder(binding.root) {

        override fun bind(
            video: Video
        ) {
            Glide.with(binding.root.context).load(video.videoThumbnail).into(binding.ivMovie)
        }


    }

    inner class MediaViewHolder(private var binding: ListItemMediaBinding) :
        MyViewHolder(binding.root) {

        override fun bind(
            video: Video
        ) {
            Glide.with(binding.root.context).load(video.videoThumbnail).into(binding.ivMovie)
        }


    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class ViewHolder(private var binding: ListItemSearchedMovieParentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: SearchedMoviesUi
        ) {
            binding.tvMovieType.text = item.movieType

        }

    }


    private enum class MediaTypes(val value: Int) {
        TV(1), MOVIE(2), OTHER(3)
    }


    abstract class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(video: Video)
    }

    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<Video>() {
                override fun areItemsTheSame(
                    oldItem: Video,
                    newItem: Video
                ): Boolean =
                    oldItem.id == newItem.id

                override fun areContentsTheSame(
                    oldItem: Video,
                    newItem: Video
                ): Boolean =
                    oldItem == newItem
            }
    }
}

