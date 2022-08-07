package com.app.vama.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = getBinding(inflater, container)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }


    protected abstract fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ViewDataBinding
}