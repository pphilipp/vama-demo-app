package com.app.vama.presentation.alboms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.vama.data.AlbumsRepository
import com.app.vama.presentation.base.UiState
import com.app.vama.presentation.model.AlbumUiModel
import com.app.vama.presentation.model.mapper.FeedResultToAlbumUiModelMapper
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.lang.Exception

class AlbumsViewModel(
    private val albumsRepository: AlbumsRepository,
    private val feedResultToAlbumUiModelMapper: FeedResultToAlbumUiModelMapper
) : ViewModel() {

    private val _uiStateFlow: MutableStateFlow<UiState> = MutableStateFlow(UiState.Idle)
    val uiStateFlow: StateFlow<UiState> = _uiStateFlow

    init {
        getAlbums(100)
    }

    fun getAlbums(amount: Int) = viewModelScope.launch {
        _uiStateFlow.value = UiState.Loading

        try {
            val feed = albumsRepository.getAlbumsList(amount)
            val mappedList: List<AlbumUiModel> = feed?.results?.map {
                feedResultToAlbumUiModelMapper.map(it)
            }?.toList() ?: emptyList()

            _uiStateFlow.value = UiState.Success(mappedList)
        } catch (e: Exception) {
            _uiStateFlow.value = UiState.Error(e.message)
        }
    }
}