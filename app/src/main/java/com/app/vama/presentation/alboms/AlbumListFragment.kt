package com.app.vama.presentation.alboms

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout.DEBUG_SHOW_NONE
import androidx.constraintlayout.motion.widget.MotionLayout.DEBUG_SHOW_PATH
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.app.vama.BuildConfig
import com.app.vama.R
import com.app.vama.databinding.FragmentAlbumListBinding
import com.app.vama.presentation.base.BaseFragment
import com.app.vama.presentation.base.UiState
import com.app.vama.presentation.model.AlbumUiModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class AlbumListFragment : BaseFragment() {

    private lateinit var binding: FragmentAlbumListBinding
    private val viewModel by viewModel<AlbumsViewModel>()

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): ViewDataBinding {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_album_list,
            container,
            false
        )

        return binding
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = super.onCreateView(inflater, container, savedInstanceState)
        setupDebugAnimationView()
        observeViewModel()
        return root
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiStateFlow.collect { state ->
                    when (state) {
                        is UiState.Error<*> -> {
                            hideProgress()
                            Toast.makeText(requireContext(), state.error.toString(), Toast.LENGTH_SHORT).show()
                        }
                        UiState.Idle -> {
                            hideProgress()
                        }
                        UiState.Loading -> {
                            showProgress()
                        }
                        is UiState.Success<*> -> {
                            hideProgress()
                            doOnSuccess(state.value as List<AlbumUiModel>)
                        }
                    }
                }
            }
        }
    }

    private fun doOnSuccess(feed: List<AlbumUiModel>) {
        val albumAdapter = AlbumAdapter {
            Toast.makeText(requireContext(), it.title, Toast.LENGTH_SHORT).show()
        }
        binding.includeContent.apply {
            rvList.adapter = albumAdapter
            rvList.layoutManager = GridLayoutManager(requireContext(), 2)
            albumAdapter.submitList(feed)
        }
    }

    private fun showProgress() {
        binding.includeProgress.progressHolder.isVisible = true
    }

    private fun hideProgress() {
        binding.includeProgress.progressHolder.isVisible = false
    }

    private fun setupDebugAnimationView() {
        when (BuildConfig.DEBUG) {
            true -> DEBUG_SHOW_PATH
            false -> DEBUG_SHOW_NONE
        }.let {
            binding.includeContent.constrainView.setDebugMode(it)
        }
    }
}