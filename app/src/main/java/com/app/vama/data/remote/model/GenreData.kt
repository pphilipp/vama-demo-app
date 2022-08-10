package com.app.vama.data.remote.model

import com.squareup.moshi.Json

data class GenreData(
   @Json(name = "genreId") val genreId: String?,
   @Json(name = "name") val name: String?,
   @Json(name = "url") val url: String?
)