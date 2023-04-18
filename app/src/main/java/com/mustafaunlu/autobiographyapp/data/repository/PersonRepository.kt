package com.mustafaunlu.autobiographyapp.data.repository

import com.mustafaunlu.autobiographyapp.data.NetworkResponse
import com.mustafaunlu.autobiographyapp.data.models.Person
import kotlinx.coroutines.flow.Flow

interface PersonRepository {
    fun getPerson(): Flow<NetworkResponse<Person>>
}
