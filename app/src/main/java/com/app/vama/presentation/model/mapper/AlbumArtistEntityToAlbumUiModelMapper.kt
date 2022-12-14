package com.app.vama.presentation.model.mapper

import com.app.vama.data.local.model.AlbumArtistEntity
import com.app.vama.presentation.model.AlbumUiModel

class AlbumArtistEntityToAlbumUiModelMapper {

    fun map(from: AlbumArtistEntity): AlbumUiModel = AlbumUiModel(
        albumId = from.id,
        title = from.name,
        subTitle = from.artistName,
        thumbnailUrl = from.artworkUrl100,
        artistUrl = from.artistUrl,
        copyright = from.copyright,
        updated = from.updated
    )
}