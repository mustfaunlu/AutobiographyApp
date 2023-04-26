package com.mustafaunlu.autobiographyapp.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Person(
    @SerializedName("about")
    val about: String,
    @SerializedName("age")
    val age: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("job")
    val job: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("portfolio")
    val portfolio: @RawValue List<Portfolio>,
    @SerializedName("social")
    val social: @RawValue List<Social>,
    @SerializedName("surname")
    val surname: String,
) : Parcelable