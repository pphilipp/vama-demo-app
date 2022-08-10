package com.app.vama.data.remote.model

import com.squareup.moshi.Json


data class ResultData(
    @Json(name = "artistId") val artistId: String?,
    @Json(name = "artistName") val artistName: String?,
    @Json(name = "artistUrl") val artistUrl: String?,
    @Json(name = "artworkUrl100") val artworkUrl100: String?,
    @Json(name = "contentAdvisoryRating") val contentAdvisoryRating: String?,
    @Json(name = "genres") val genres: List<GenreData>?,
    @Json(name = "id") val id: String?,
    @Json(name = "kind") val kind: String?,
    @Json(name = "name") val name: String?,
    @Json(name = "releaseDate") val releaseDate: String?,
    @Json(name = "url") val url: String?
)