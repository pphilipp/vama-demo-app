package com.app.vama.data.remote

import com.app.vama.data.remote.model.Feed
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
//    https://rss.applemarketingtools.com/api/v2/  us/music/most-played/10/albums.json

    @GET("us/music/most-played/{amount}/albums.json")
    suspend fun fetchAlbums(
        @Path(value = "amount", encoded = true) amount: Int
    ): Feed

}