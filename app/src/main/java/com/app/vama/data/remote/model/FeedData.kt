package com.app.vama.data.remote.model

import com.squareup.moshi.Json

data class FeedData(
    @Json(name = "id")  val id: String?,
    @Json(name = "author")  val author: AuthorData?,
    @Json(name = "copyright")  val copyright: String?,
    @Json(name = "country")  val country: String?,
    @Json(name = "icon")  val icon: String?,
    @Json(name = "links")  val links: List<LinkData>?,
    @Json(name = "results")  val results: List<ResultData>?,
    @Json(name = "title")  val title: String?,
    @Json(name = "updated")  val updated: String?
)