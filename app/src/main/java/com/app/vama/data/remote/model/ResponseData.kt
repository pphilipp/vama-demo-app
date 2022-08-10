package com.app.vama.data.remote.model

import com.squareup.moshi.Json

data class ResponseData(
    @Json(name = "feed")  val feed: FeedData?,
)