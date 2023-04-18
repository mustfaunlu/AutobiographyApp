package com.mustafaunlu.autobiographyapp.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Social(
    @Json(name = "image")
    val image: String,
    @Json(name = "link")
    val link: String,
    @Json(name = "title")
    val title: String,
)
