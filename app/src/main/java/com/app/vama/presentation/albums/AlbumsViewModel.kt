package com.app.vama.presentation.albums

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.vama.data.AlbumsRepository
import com.app.vama.presentation.base.UiState
import com.app.vama.presentation.model.AlbumUiModel
import com.app.vama.presentation.model.mapper.AlbumArtistEntityToAlbumUiModelMapper
import com.app.vama.presentation.model.mapper.FeedResultToAlbumUiModelMapper
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.lang.Exception
import java.net.UnknownHostException

class AlbumsViewModel(
    private val albumsRepository: AlbumsRepository,
    private val feedResultToAlbumUiModelMapper: FeedResultToAlbumUiModelMapper,
    private val albumArtistEntityToAlbumUiModelMapper: AlbumArtistEntityToAlbumUiModelMapper
) : ViewModel() {

    private val _uiStateFlow: MutableStateFlow<UiState> = MutableStateFlow(UiState.Idle)
    val uiStateFlow: StateFlow<UiState> = _uiStateFlow

    init {
        getAlbums(100, forceLoad = true)
    }

    fun getAlbums(amount: Int, forceLoad: Boolean = false) = viewModelScope.launch {
        _uiStateFlow.value = UiState.Loading

        try {
            val mappedList: List<AlbumUiModel> =
                if (forceLoad) {
                    fetchRemoteAndSaveLocally(amount)
                } else {
                    getAllFromLocal()
                }

            _uiStateFlow.value = UiState.Success(mappedList)
        } catch (e: Exception) {
            when(e) {
                is UnknownHostException -> {
                    _uiStateFlow.value = UiState.Success(getAllFromLocal())
                }
            }

            _uiStateFlow.value = UiState.Error(e.message)
        }
    }

    private suspend fun getAllFromLocal(): List<AlbumUiModel> =
        albumsRepository.getCashedAllAlbums()
            .map {
                albumArtistEntityToAlbumUiModelMapper.map(it)
            }

    private suspend fun fetchRemoteAndSaveLocally(amount: Int): List<AlbumUiModel> =
        albumsRepository.getAlbumsList(amount)?.results
            ?.map {
                feedResultToAlbumUiModelMapper.map(it)
            }
            ?.toList()
            ?: emptyList()

}