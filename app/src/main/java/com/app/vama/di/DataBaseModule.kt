package com.app.vama.di

import android.content.Context
import androidx.room.Room
import com.app.vama.data.local.DataBase
import org.koin.dsl.module

const val DATA_BASE_NAME = "data_base_vama"
const val TABLE_ALBUM_ARTIST = "table_album_artist"
const val TABLE_LINK = "table_link"
const val TABLE_GENRE = "table_genre"
const val TABLE_FEED = "table_feed"
const val TABLE_AUTHOR = "table_author"

val dbModule = module {

    fun provideDB(context: Context) = Room.databaseBuilder(
        context,
        DataBase::class.java,
        DATA_BASE_NAME
    ).build()

}