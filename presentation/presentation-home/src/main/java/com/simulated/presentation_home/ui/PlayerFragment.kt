package com.simulated.presentation_home.ui

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.simulated.presentation_common.base_classes.BaseFragment
import com.simulated.presentation_home.R
import com.simulated.presentation_home.databinding.FragmentPlayerBinding

class PlayerFragment : BaseFragment<FragmentPlayerBinding>() {

    private val args: PlayerFragmentArgs by navArgs()

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPlayerBinding {
        return FragmentPlayerBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE


        Glide.with(requireActivity()).load(args.url).placeholder(
            ResourcesCompat.getDrawable(
                resources,
                R.drawable.place_holder_video, null
            )
        )
            .into(binding.ivPoster)

    }

    override fun onDestroy() {
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

        super.onDestroy()
    }
}