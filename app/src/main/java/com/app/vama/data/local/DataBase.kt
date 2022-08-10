package com.app.vama.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.vama.data.local.DataBase.Companion.APP_DATABASE_VERSION_1
import com.app.vama.data.local.model.*

@Database(
    entities = [
        ResultEntity::class, LinkEntity::class, GenreEntity::class,
        FeedEntity::class, AuthorEntity::class],
    version = APP_DATABASE_VERSION_1,
    exportSchema = false
)
abstract class DataBase : RoomDatabase() {

    companion object {
        const val APP_DATABASE_VERSION_1 = 1
    }

//    abstract fun Dao(): DAO

}