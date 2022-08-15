package com.app.vama.presentation.model.mapper

import com.app.vama.data.remote.model.ResultData
import com.app.vama.presentation.model.AlbumUiModel
import com.app.vama.util.EMPTY_STRING

class FeedResultToAlbumUiModelMapper : UiMapper<ResultData, AlbumUiModel> {

    override fun map(from: ResultData): AlbumUiModel = AlbumUiModel(
        albumId = from.id ?: EMPTY_STRING,
        title = from.name ?: EMPTY_STRING,
        subTitle = from.artistName ?: EMPTY_STRING,
        thumbnailUrl = from.artworkUrl100 ?: EMPTY_STRING,
        artistUrl = from.artistUrl ?: EMPTY_STRING,
        copyright = EMPTY_STRING,
        updated = EMPTY_STRING
    )
}