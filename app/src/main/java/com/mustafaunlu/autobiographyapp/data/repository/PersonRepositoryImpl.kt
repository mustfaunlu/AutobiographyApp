package com.mustafaunlu.autobiographyapp.data.repository

import com.mustafaunlu.autobiographyapp.data.NetworkResponse
import com.mustafaunlu.autobiographyapp.data.database.PersonEntity
import com.mustafaunlu.autobiographyapp.data.datasource.local.LocalDataSource
import com.mustafaunlu.autobiographyapp.data.datasource.remote.RemoteDataSource
import com.mustafaunlu.autobiographyapp.data.models.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PersonRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource) : PersonRepository {
    override fun getPerson(): Flow<NetworkResponse<Person>> =
        flow {
            emit(NetworkResponse.Loading)
            when (val response = remoteDataSource.getPersonData()) {
                is NetworkResponse.Error -> {
                    emit(NetworkResponse.Error(response.exception))
                }
                NetworkResponse.Loading -> emit(NetworkResponse.Loading)
                is NetworkResponse.Success -> {
                    insertPerson(response.result.toPersonEntity())
                    emit(NetworkResponse.Success(getPersonFromDatabase().toPerson()))
                }
            }
        }.flowOn(Dispatchers.IO)

    override suspend fun getPersonFromDatabase(): PersonEntity =
        withContext(Dispatchers.IO) {
            localDataSource.getPerson()
        }

    override suspend fun insertPerson(person: PersonEntity) =
        withContext(Dispatchers.IO) {
            localDataSource.insertPerson(person)
        }
}

// response to database entity model mapper
fun Person.toPersonEntity(): PersonEntity {
    return PersonEntity(
        id = this.id,
        name = this.name,
        surname = this.surname,
        about = this.about,
        age = this.age,
        job = this.job,
        image = this.image,
        social = this.social,
        portfolio = this.portfolio,
        description = this.description,
    )
}

// database entity model to response mapper
fun PersonEntity.toPerson(): Person {
    return Person(
        id = this.id,
        name = this.name,
        surname = this.surname,
        about = this.about,
        age = this.age,
        job = this.job,
        image = this.image,
        social = this.social,
        portfolio = this.portfolio,
        description = this.description,
    )
}
