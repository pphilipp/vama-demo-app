package com.app.vama.presentation.albums

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.vama.domain.GetAlbumsListUseCase
import com.app.vama.domain.GetAllCashedAlbumsUseCase
import com.app.vama.presentation.base.UiState
import com.app.vama.presentation.model.AlbumUiModel
import com.app.vama.presentation.model.mapper.AlbumArtistEntityToAlbumUiModelMapper
import com.app.vama.presentation.model.mapper.FeedResultToAlbumUiModelMapper
import kotlinx.coroutines.flow.*
import  com.app.vama.domain.execute
import kotlinx.coroutines.launch
import java.lang.Exception
import java.net.UnknownHostException

class AlbumsViewModel(
    private val feedResultToAlbumUiModelMapper: FeedResultToAlbumUiModelMapper,
    private val albumArtistEntityToAlbumUiModelMapper: AlbumArtistEntityToAlbumUiModelMapper,
    private val getAllCashedAlbumsUseCase: GetAllCashedAlbumsUseCase,
    private val getAlbumsListUseCase: GetAlbumsListUseCase
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
            when (e) {
                is UnknownHostException -> {
                    _uiStateFlow.value = UiState.Success(getAllFromLocal())
                }
            }

            _uiStateFlow.value = UiState.Error(e.message)
        }
    }

    private suspend fun getAllFromLocal(): List<AlbumUiModel> =
        getAllCashedAlbumsUseCase.execute().first()
            .map {
                albumArtistEntityToAlbumUiModelMapper.map(it)
            }

    private suspend fun fetchRemoteAndSaveLocally(amount: Int): List<AlbumUiModel> =
        getAlbumsListUseCase.execute(
            params = GetAlbumsListUseCase.Params(amount = amount)
        ).first()?.results
            ?.map {
                feedResultToAlbumUiModelMapper.map(it)
            }
            ?.toList()
            ?: emptyList()
}