package com.app.vama.data.mapper

import com.app.vama.data.local.model.AlbumArtistEntity
import com.app.vama.data.remote.model.ResultData
import com.app.vama.util.EMPTY_STRING

class ResultDataToAlbumArtistEntityMapper {

    fun map(from: ResultData): AlbumArtistEntity =
        AlbumArtistEntity(
            artistId = from.artistId ?: EMPTY_STRING,
            artistName = from.artistName ?: EMPTY_STRING,
            artistUrl = from.artistUrl ?: EMPTY_STRING,
            artworkUrl100 = from.artworkUrl100 ?: EMPTY_STRING,
            contentAdvisoryRating = from.contentAdvisoryRating ?: EMPTY_STRING,
            id = from.id ?: EMPTY_STRING,
            kind = from.kind ?: EMPTY_STRING,
            name = from.name ?: EMPTY_STRING,
            releaseDate = from.releaseDate ?: EMPTY_STRING,
            url = from.url ?: EMPTY_STRING
        )
}
