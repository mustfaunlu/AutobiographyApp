package com.mustafaunlu.autobiographyapp.data.datasource.remote

import com.mustafaunlu.autobiographyapp.data.NetworkResponse
import com.mustafaunlu.autobiographyapp.data.models.Person

interface RemoteDataSource {
    suspend fun getPersonData(): NetworkResponse<Person>
}
