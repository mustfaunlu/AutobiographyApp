package com.mustafaunlu.autobiographyapp.data.datasource

import com.mustafaunlu.autobiographyapp.data.NetworkResponse
import com.mustafaunlu.autobiographyapp.data.api.ApiService
import com.mustafaunlu.autobiographyapp.data.models.Person
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api: ApiService) : RemoteDataSource {
    override suspend fun getPersonData(): NetworkResponse<Person> =
        try {
            val response = api.getPersonData()
            NetworkResponse.Success(response)
        } catch (e: Exception) {
            NetworkResponse.Error(e)
        }
}
