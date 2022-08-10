package com.app.vama.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.vama.di.TABLE_LINK

@Entity(tableName = TABLE_LINK)
data class LinkEntity(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "self") val self: String?
)