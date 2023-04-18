package com.mustafaunlu.autobiographyapp.data.repository

import com.mustafaunlu.autobiographyapp.data.NetworkResponse
import com.mustafaunlu.autobiographyapp.data.datasource.RemoteDataSource
import com.mustafaunlu.autobiographyapp.data.models.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PersonRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) : PersonRepository {
    override fun getPerson(): Flow<NetworkResponse<Person>> =
        flow {
            emit(NetworkResponse.Loading)
            when (val response = remoteDataSource.getPersonData()) {
                is NetworkResponse.Error -> {
                    emit(NetworkResponse.Error(response.exception))
                }
                NetworkResponse.Loading -> emit(NetworkResponse.Loading)
                is NetworkResponse.Success -> {
                    emit(NetworkResponse.Success(response.result))
                }
            }
        }.flowOn(Dispatchers.IO)
}
