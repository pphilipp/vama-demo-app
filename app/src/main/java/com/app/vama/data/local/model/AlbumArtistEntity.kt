package com.app.vama.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.vama.di.TABLE_ALBUM_ARTIST
import com.app.vama.util.EMPTY_STRING

@Entity(tableName = TABLE_ALBUM_ARTIST)
data class AlbumArtistEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: String = EMPTY_STRING,
    @ColumnInfo(name = "artistId") val artistId: String = EMPTY_STRING,
    @ColumnInfo(name = "artistName") val artistName: String = EMPTY_STRING,
    @ColumnInfo(name = "artistUrl") val artistUrl: String = EMPTY_STRING,
    @ColumnInfo(name = "artworkUrl100") val artworkUrl100: String = EMPTY_STRING,
    @ColumnInfo(name = "contentAdvisoryRating") val contentAdvisoryRating: String = EMPTY_STRING,
    @ColumnInfo(name = "kind") val kind: String = EMPTY_STRING,
    @ColumnInfo(name = "name") val name: String = EMPTY_STRING,
    @ColumnInfo(name = "releaseDate") val releaseDate: String = EMPTY_STRING,
    @ColumnInfo(name = "url") val url: String = EMPTY_STRING
)