package com.app.vama.di

import android.app.Application
import androidx.room.Room
import com.app.vama.data.local.VamaDataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

const val DATA_BASE_NAME = "data_base_vama"
const val TABLE_ALBUM_ARTIST = "table_album_artist"
const val TABLE_LINK = "table_link"
const val TABLE_GENRE = "table_genre"
const val TABLE_FEED = "table_feed"
const val TABLE_AUTHOR = "table_author"

val dbModule = module {

    single { provideDB(androidApplication()) }
    single {
        val db = get<VamaDataBase>()
        db.vamaDao
    }
}

fun provideDB(application: Application): VamaDataBase = Room.databaseBuilder(
    application,
    VamaDataBase::class.java,
    DATA_BASE_NAME
).build()
