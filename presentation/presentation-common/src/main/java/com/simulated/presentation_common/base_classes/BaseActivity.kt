package com.simulated.presentation_common.base_classes

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : Activity() {

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    abstract fun inflateBinding(inflater: LayoutInflater): VB


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = inflateBinding(layoutInflater)
        setContentView(binding.root)

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}