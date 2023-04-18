package com.mustafaunlu.autobiographyapp.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Portfolio(
    @Json(name = "description")
    val description: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "title")
    val title: String,
)
