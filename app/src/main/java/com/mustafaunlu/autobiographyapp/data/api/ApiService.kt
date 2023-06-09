package com.mustafaunlu.autobiographyapp.data.api

import com.mustafaunlu.autobiographyapp.data.models.Person
import retrofit2.http.GET

interface ApiService {
    @GET("person.json")
    suspend fun getPersonData(): Person
}
