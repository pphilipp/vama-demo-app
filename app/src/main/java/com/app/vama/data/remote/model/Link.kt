package com.app.vama.data.remote.model

import com.squareup.moshi.Json

data class Link(
    @Json(name = "self") val self: String
)