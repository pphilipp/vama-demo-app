package com.app.vama.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.vama.di.TABLE_FEED

@Entity(tableName = TABLE_FEED)
data class FeedEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "author")  val author: AuthorEntity?,
    @ColumnInfo(name = "copyright")  val copyright: String?,
    @ColumnInfo(name = "country")  val country: String?,
    @ColumnInfo(name = "icon")  val icon: String?,
    @ColumnInfo(name = "links")  val links: List<LinkEntity>?,
    @ColumnInfo(name = "results")  val results: List<ResultEntity>?,
    @ColumnInfo(name = "title")  val title: String?,
    @ColumnInfo(name = "updated")  val updated: String?
)