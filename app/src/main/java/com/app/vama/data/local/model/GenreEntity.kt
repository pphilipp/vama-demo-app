package com.app.vama.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.vama.di.TABLE_GENRE

@Entity(tableName = TABLE_GENRE)
data class GenreEntity(
   @PrimaryKey val uid: Int,
   @ColumnInfo(name = "genreId") val genreId: String?,
   @ColumnInfo(name = "name") val name: String?,
   @ColumnInfo(name = "url") val url: String?
)