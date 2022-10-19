package com.simulated.presentation_home.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.DefaultTimeBar
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.google.android.exoplayer2.util.Util
import com.simulated.presentation_common.base_classes.BaseActivity
import com.simulated.presentation_common.hide
import com.simulated.presentation_common.show
import com.simulated.presentation_home.R
import com.simulated.presentation_home.databinding.ActivityPlayerBinding


class PlayerActivity : BaseActivity<ActivityPlayerBinding>() {
    val TAG = PlayerActivity::class.java.simpleName

    private var url =
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"


    private lateinit var simpleExoPlayer: ExoPlayer

    private var currentWindow = 0
    private var playbackPosition: Long = 0
    private var isPlayerPlaying = true

    override fun inflateBinding(inflater: LayoutInflater): ActivityPlayerBinding {
        return ActivityPlayerBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializePlayer()
    }


    private fun initializePlayer() {



        val mediaDataSourceFactory: DataSource.Factory = DefaultDataSource.Factory(this)

        val mediaSource = ProgressiveMediaSource.Factory(mediaDataSourceFactory)
            .createMediaSource(MediaItem.fromUri(url))

        val mediaSourceFactory = DefaultMediaSourceFactory(mediaDataSourceFactory)

        simpleExoPlayer = ExoPlayer.Builder(this)
            .setMediaSourceFactory(mediaSourceFactory)
            .build().apply {
                addMediaSource(mediaSource)
                seekTo(currentWindow, playbackPosition)
                prepare()
            }

        binding.playerView.player = simpleExoPlayer
        binding.playerView.requestFocus()


        simpleExoPlayer.addListener(object : Player.Listener {
            override fun onPlaybackStateChanged(playbackState: Int) {
                super.onPlaybackStateChanged(playbackState)

                Log.d(TAG, "onPlaybackStateChanged: $playbackState")

                when (playbackState) {

                    Player.STATE_BUFFERING -> {
                        Log.d(TAG, "onPlaybackStateChanged: STATE_BUFFERING")
                        binding.progressBar.show()
                    }

                    Player.STATE_READY -> {
                        Log.d(TAG, "onPlaybackStateChanged: STATE_READY")
                        binding.progressBar.hide()
                    }

                    Player.STATE_ENDED -> {
                        Log.d(TAG, "onPlaybackStateChanged: STATE_ENDED")
                    }
                    Player.STATE_IDLE -> {
                        Log.d(TAG, "onPlaybackStateChanged: STATE_IDLE")

                    }
                }
            }


        })

    }


    private fun releasePlayer() {
        isPlayerPlaying = simpleExoPlayer.playWhenReady
        playbackPosition = simpleExoPlayer.currentPosition
        currentWindow = simpleExoPlayer.currentWindowIndex
        simpleExoPlayer.playWhenReady = false
        simpleExoPlayer.stop()
        simpleExoPlayer.release()
    }



    public override fun onStart() {
        super.onStart()

        Log.d(TAG, "onStart: ")

        if (Util.SDK_INT > 23) {
            initializePlayer()
        }
    }

    public override fun onResume() {
        super.onResume()

        Log.d(TAG, "onResume: ")
        if (Util.SDK_INT <= 23) {
            initializePlayer()
        }
    }

    public override fun onPause() {
        super.onPause()

        Log.d(TAG, "onPause: ")

        if (Util.SDK_INT <= 23) {
            releasePlayer()
        }
    }

    public override fun onStop() {
        super.onStop()

        Log.d(TAG, "onStop: ")

        if (Util.SDK_INT > 23) {
            releasePlayer()
        }
    }

}