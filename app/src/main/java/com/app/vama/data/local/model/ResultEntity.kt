package com.app.vama.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.vama.di.TABLE_ALBUM_ARTIST

@Entity(tableName = TABLE_ALBUM_ARTIST)
data class ResultEntity(
    @PrimaryKey
    @ColumnInfo(name = "artistId") val artistId: String?,
    @ColumnInfo(name = "artistName") val artistName: String?,
    @ColumnInfo(name = "artistUrl") val artistUrl: String?,
    @ColumnInfo(name = "artworkUrl100") val artworkUrl100: String?,
    @ColumnInfo(name = "contentAdvisoryRating") val contentAdvisoryRating: String?,
    @ColumnInfo(name = "genres") val genres: List<GenreEntity>?,
    @ColumnInfo(name = "id") val id: String?,
    @ColumnInfo(name = "kind") val kind: String?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "releaseDate") val releaseDate: String?,
    @ColumnInfo(name = "url") val url: String?
)