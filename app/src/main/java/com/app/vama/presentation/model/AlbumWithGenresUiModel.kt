package com.app.vama.presentation.model

data class AlbumWithGenresUiModel(
    val albumUiModel: AlbumUiModel,
    val genreList: List<GenreUiModel> = emptyList()
)