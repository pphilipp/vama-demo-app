package com.app.vama.data

import com.app.vama.data.data_source.ApiDataSource
import com.app.vama.data.data_source.DataBaseDataSource
import com.app.vama.data.remote.model.FeedData

class AlbumsRepository(
    private val apiDataSource: ApiDataSource,
    private val dataBaseDataSource: DataBaseDataSource,
) {

    suspend fun getAlbumsList(amount: Int): FeedData? =
        apiDataSource.fetchAlbums(amount)
}