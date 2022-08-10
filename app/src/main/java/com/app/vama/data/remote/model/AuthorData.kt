package com.app.vama.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class AuthorData(
    @Json(name = "name")val name: String?,
    @Json(name = "url") val url: String?
)