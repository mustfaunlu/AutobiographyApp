package com.mustafaunlu.autobiographyapp.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Person(
    @Json(name = "about")
    val about: String,
    @Json(name = "age")
    val age: Int,
    @Json(name = "description")
    val description: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "image")
    val image: String,
    @Json(name = "job")
    val job: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "portfolio")
    val portfolio: List<Portfolio>,
    @Json(name = "social")
    val social: List<Social>,
    @Json(name = "surname")
    val surname: String,
)
