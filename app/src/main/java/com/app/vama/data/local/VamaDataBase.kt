package com.app.vama.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.vama.data.local.VamaDataBase.Companion.APP_DATABASE_VERSION_1
import com.app.vama.data.local.model.*

@Database(
    entities = [
        AlbumArtistEntity::class,
        GenreEntity::class
    ],
    version = APP_DATABASE_VERSION_1,
    exportSchema = false
)
abstract class VamaDataBase : RoomDatabase() {

    companion object {
        const val APP_DATABASE_VERSION_1 = 1
    }

    abstract val vamaDao: VamaDAO

}