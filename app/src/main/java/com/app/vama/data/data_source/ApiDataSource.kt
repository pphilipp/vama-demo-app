package com.app.vama.data.data_source

import com.app.vama.data.remote.ApiService
import com.app.vama.data.remote.model.FeedData

class ApiDataSource(
    private val apiService: ApiService
) {

    suspend fun fetchAlbums(amount: Int): FeedData? =
        apiService.fetchAlbums(amount).feed
}