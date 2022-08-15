package com.app.vama.presentation.model.mapper

import com.app.vama.data.remote.model.ResultData
import com.app.vama.presentation.model.AlbumUiModel

class FeedResultToAlbumUiModelMapper : UiMapper<ResultData, AlbumUiModel> {

    override fun map(from: ResultData): AlbumUiModel = AlbumUiModel(
        albumId = from.id ?: "",
        title = from.name ?: "",
        subTitle = from.artistName ?: "",
        thumbnailUrl = from.artworkUrl100 ?: ""
    )
}