package com.app.vama.data.remote.model

import com.squareup.moshi.Json

data class Feed(
    @Json(name = "author") val author: Author,
    @Json(name = "copyright") val copyright: String,
    @Json(name = "country") val country: String,
    @Json(name = "icon") val icon: String,
    @Json(name = "id") val id: String,
    @Json(name = "links") val links: List<Link>,
    @Json(name = "results") val results: List<Result>,
    @Json(name = "title") val title: String,
    @Json(name = "updated") val updated: String
)