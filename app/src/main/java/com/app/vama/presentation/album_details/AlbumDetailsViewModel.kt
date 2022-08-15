package com.app.vama.presentation.album_details

import androidx.lifecycle.ViewModel
import com.app.vama.data.AlbumsRepository
import com.app.vama.domain.GetAlbumByIdUseCase
import com.app.vama.presentation.base.UiState
import com.app.vama.presentation.model.AlbumWithGenresUiModel
import com.app.vama.presentation.model.GenreUiModel
import com.app.vama.presentation.model.mapper.AlbumArtistEntityToAlbumUiModelMapper
import com.app.vama.presentation.model.mapper.GenreEntityToGenreUiModelMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import java.lang.Exception

class AlbumDetailsViewModel(
    private val getAlbumByIdUseCase: GetAlbumByIdUseCase,
) : ViewModel() {

    private val _uiStateFlow: MutableStateFlow<UiState> = MutableStateFlow(UiState.Idle)
    val uiStateFlow: StateFlow<UiState> = _uiStateFlow

    suspend fun getAlbumById(id: String) {
        _uiStateFlow.value = UiState.Loading

        try {
            val params = GetAlbumByIdUseCase.GetAlbumByIdUseCaseParams(id = id)
            val albumWithGenresUiModel = getAlbumByIdUseCase.execute(params).first()

            _uiStateFlow.value = UiState.Success(albumWithGenresUiModel)
        } catch (e: Exception) {
            _uiStateFlow.value = UiState.Error(e)
        }
    }

}