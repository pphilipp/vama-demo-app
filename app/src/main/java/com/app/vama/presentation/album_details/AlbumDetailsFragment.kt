package com.app.vama.presentation.album_details

import android.content.Context
import android.content.res.Resources
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Keep
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.app.vama.R
import com.app.vama.databinding.FragmentAlbumDetailsBinding
import com.app.vama.presentation.base.BaseFragment
import com.app.vama.presentation.base.UiState
import com.app.vama.presentation.model.AlbumWithGenresUiModel
import com.app.vama.presentation.model.GenreUiModel
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import kotlinx.coroutines.launch
import kotlinx.parcelize.Parcelize
import org.koin.androidx.viewmodel.ext.android.viewModel


@Parcelize
@Keep
data class ArgumentAlbumDetailsFragment(
    var albumId: String
) : Parcelable

class AlbumDetailsFragment : BaseFragment() {

    private lateinit var binding: FragmentAlbumDetailsBinding
    private val viewModel by viewModel<AlbumDetailsViewModel>()
    private val args: AlbumDetailsFragmentArgs by navArgs()

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): ViewDataBinding {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_album_details,
            container,
            false
        )

        return binding
    }

    override fun setLightStatusBars() = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = super.onCreateView(inflater, container, savedInstanceState)
        handleArguments()
        observeViewModel()
        return root
    }

    private fun handleArguments() {
        args.albumId.let {
            lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.getAlbumById(it.albumId)
                }
            }
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiStateFlow.collect { state ->
                    when (state) {
                        is UiState.Error<*> -> {
                            hideProgress()
                        }
                        UiState.Idle -> {
                            hideProgress()
                        }
                        UiState.Loading -> {
                            showProgress()
                        }
                        is UiState.Success<*> -> {
                            hideProgress()
                            onSuccess((state.value as AlbumWithGenresUiModel))
                        }
                    }
                }
            }
        }
    }

    private fun onSuccess(uiModel: AlbumWithGenresUiModel) {
        Glide
            .with(binding.ivTopPicture.context)
            .load(uiModel.albumUiModel.thumbnailUrl)
            .centerCrop()
            .into(binding.ivTopPicture)

        binding.tvTitle.text = uiModel.albumUiModel.title
        binding.tvSubtitle.text = uiModel.albumUiModel.subTitle
        binding.tvCopyright.text = uiModel.albumUiModel.copyright
        binding.tvUpdated.text = uiModel.albumUiModel.updated

        binding.btnVisitAlbum.setOnClickListener {
            showCustomTab(uiModel)
        }

        populateGenresList(uiModel.genreList)
    }

    private fun showCustomTab(uiModel: AlbumWithGenresUiModel) {
        CustomTabsIntent.Builder().apply {
            setDefaultColorSchemeParams(
                CustomTabColorSchemeParams.Builder().apply {
                    setToolbarColor(resources.getColor(R.color.blue))
                }.build()
            )
        }
            .build()
            .launchUrl(requireContext(), Uri.parse(uiModel.albumUiModel.artistUrl))
    }

    private fun populateGenresList(genreList: List<GenreUiModel>) {
        binding.chipGroup.removeAllViews()

        genreList
            .map {
                createTagChip(requireContext(), it.name)
            }
            .forEach {
                binding.chipGroup.addView(it)
            }
    }

    private fun createTagChip(
        context: Context,
        chipName: String
    ) = Chip(context).apply {
        text = chipName
        setChipBackgroundColorResource(android.R.color.transparent)
        isCloseIconVisible = false
        setTextColor(ContextCompat.getColor(context, R.color.blue))
        setTextAppearance(R.style.ChipTextAppearance)
    }

    private fun showProgress() {
        binding.includeProgress.progressHolder.isVisible = true
    }

    private fun hideProgress() {
        binding.includeProgress.progressHolder.isVisible = false
    }
}