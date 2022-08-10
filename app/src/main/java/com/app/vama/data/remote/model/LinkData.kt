package com.app.vama.data.remote.model

import com.squareup.moshi.Json

data class LinkData(
    @Json(name = "self") val self: String?
)