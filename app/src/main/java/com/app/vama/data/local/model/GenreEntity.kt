package com.app.vama.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.vama.di.TABLE_GENRE
import com.app.vama.util.EMPTY_STRING

@Entity(tableName = TABLE_GENRE)
data class GenreEntity(
    @ColumnInfo(name = "genreId") val genreId: String = EMPTY_STRING,
    @ColumnInfo(name = "name") val name: String = EMPTY_STRING,
    @ColumnInfo(name = "url") val url: String = EMPTY_STRING,
    @PrimaryKey
    @ColumnInfo(name = "artist_related_Id") val artistId: String = EMPTY_STRING
)