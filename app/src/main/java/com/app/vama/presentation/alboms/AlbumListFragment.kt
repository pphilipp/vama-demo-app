package com.app.vama.presentation.alboms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.app.vama.R
import com.app.vama.databinding.FragmentAlbumListBinding
import com.app.vama.presentation.base.BaseFragment
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

        observeViewModel()
        binding.tvTitleExpanded.text = "100 top asd"

        return root
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getMockList().collect {
                    val albumAdapter = AlbumAdapter {
                        Toast.makeText(requireContext(), "${it.title}", Toast.LENGTH_SHORT).show()
                    }
                    binding.rvList.adapter = albumAdapter
                    binding.rvList.layoutManager = GridLayoutManager(requireContext(), 2)
                    albumAdapter.submitList(it)
                }
            }
        }
    }
}