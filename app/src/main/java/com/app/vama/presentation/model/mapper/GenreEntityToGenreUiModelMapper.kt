package com.app.vama.presentation.model.mapper

import com.app.vama.data.local.model.GenreEntity
import com.app.vama.presentation.model.GenreUiModel

class GenreEntityToGenreUiModelMapper: UiMapper<GenreEntity, GenreUiModel> {

    override fun map(from: GenreEntity)= GenreUiModel(
        genreId = from.genreId,
        name = from.name,
        url = from.url,
        artistId = from.artistId
    )
}