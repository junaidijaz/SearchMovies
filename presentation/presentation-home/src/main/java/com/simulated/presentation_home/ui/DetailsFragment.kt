package com.simulated.presentation_home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.simulated.presentation_common.base_classes.BaseFragment
import com.simulated.presentation_common.hide
import com.simulated.presentation_common.show
import com.simulated.presentation_home.Constants
import com.simulated.presentation_home.databinding.FragmentDetailsBinding
import com.simulated.presentation_home.models.VideoUi

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

    val args: DetailsFragmentArgs by navArgs()

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailsBinding {
        return FragmentDetailsBinding.inflate(layoutInflater)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi(args.item)


    }

    private fun initUi(item: VideoUi) {
        if (item.mediaType == Constants.MediaTypes.TV.value || item.mediaType == Constants.MediaTypes.MOVIE.value) {
            binding.ivPlay.show()
            binding.tvItemTittle.text = item.title

            binding.ivPlay.setOnClickListener {
                val action =
                    DetailsFragmentDirections.actionDetailsFragmentToPlayerFragment(item.videoLogoOriginal)
                findNavController().navigate(action)

            }

        } else {
            binding.tvItemTittle.text = item.name
            binding.ivPlay.hide()
        }

        binding.tvItemDis.text = item.overview

        Glide.with(requireActivity()).load(item.videoLogoOriginal)
            .into(binding.ivMovieDetail)



    }
}