package com.app.vama.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.vama.di.TABLE_AUTHOR

@Entity(tableName = TABLE_AUTHOR)
data class AuthorEntity(
    @PrimaryKey
    @ColumnInfo(name = "name")val name: String?,
    @ColumnInfo(name = "url") val url: String?
)