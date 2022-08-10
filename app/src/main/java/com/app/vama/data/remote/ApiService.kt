package com.app.vama.data.remote

import com.app.vama.data.remote.model.FeedData
import com.app.vama.data.remote.model.ResponseData
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("us/music/most-played/{amount}/albums.json")
    suspend fun fetchAlbums(
        @Path(value = "amount", encoded = true) amount: Int
    ): ResponseData

}