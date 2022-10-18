package com.simulated.presentation_home.ui.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.simulated.presentation_home.Constants
import com.simulated.presentation_home.R
import com.simulated.presentation_home.databinding.ListItemMediaBinding
import com.simulated.presentation_home.databinding.ListItemMovieBinding
import com.simulated.presentation_home.databinding.ListItemTvBinding
import com.simulated.presentation_home.models.VideoUi


class SearchedMoviesChildAdapter(context: Context, var mListener: ((VideoUi) -> Unit)?) :
    ListAdapter<VideoUi, SearchedMoviesChildAdapter.MyViewHolder>(
        DIFF_CALLBACK
    ) {


    private var thumb: Drawable?

    init {
        thumb = ResourcesCompat.getDrawable(context.resources, R.drawable.place_holder_video, null)

    }


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
            Constants.MediaTypes.MOVIE.value -> {
                MediaTypes.MOVIE.value
            }
            Constants.MediaTypes.TV.value -> {
                MediaTypes.TV.value
            }
            else -> {
                MediaTypes.OTHER.value
            }
        }
    }

    inner class MovieViewHolder(private var binding: ListItemMovieBinding) :
        MyViewHolder(binding.root) {
        override fun bind(video: VideoUi) {

            Glide.with(binding.root.context).load(video.videoThumbnail)
                .placeholder(thumb).into(binding.ivMovie)

            binding.root.setOnClickListener {
                mListener?.invoke(video)
            }
        }
    }

    inner class TvViewHolder(private var binding: ListItemTvBinding) :
        MyViewHolder(binding.root) {

        override fun bind(
            video: VideoUi
        ) {

            Glide.with(binding.root.context).load(video.videoThumbnail)
                .placeholder(thumb).into(binding.ivMovie)

            binding.root.setOnClickListener {
                mListener?.invoke(video)
            }
        }


    }

    inner class MediaViewHolder(private var binding: ListItemMediaBinding) :
        MyViewHolder(binding.root) {

        override fun bind(
            video: VideoUi
        ) {

            Glide.with(binding.root.context).load(video.videoThumbnail)
                .placeholder(thumb)
                .into(binding.ivMovie)

            binding.tvPersonName.text = video.name

            binding.root.setOnClickListener {
                mListener?.invoke(video)
            }
        }

    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    private enum class MediaTypes(val value: Int) {
        TV(1), MOVIE(2), OTHER(3)
    }


    abstract class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(video: VideoUi)
    }

    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<VideoUi>() {
                override fun areItemsTheSame(
                    oldItem: VideoUi,
                    newItem: VideoUi
                ): Boolean =
                    oldItem.id == newItem.id

                override fun areContentsTheSame(
                    oldItem: VideoUi,
                    newItem: VideoUi
                ): Boolean =
                    oldItem == newItem
            }
    }

}

