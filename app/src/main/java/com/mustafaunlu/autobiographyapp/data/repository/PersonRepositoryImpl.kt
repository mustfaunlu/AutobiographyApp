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

/**
 * Repository pattern kullanılarak network'den gelen veriler
 * database'e kaydediliyor. Eğer daha önce database'e kaydedilmiş
 * veri yoksa, network'den veri çekiliyor. Database'e kaydedilen
 * veriler getPerson() fonksiyonu ile viewModel tarafindan kullaniliyor.
 */
class PersonRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource) : PersonRepository {
    private var cachedPersonData: PersonEntity? = null
    override fun getPerson(): Flow<NetworkResponse<Person>> =
        flow {
            emit(NetworkResponse.Loading)
            if (cachedPersonData != null) {
                emit(NetworkResponse.Success(cachedPersonData!!.toPerson()))
            } else {
                when (val response = remoteDataSource.getPersonData()) {
                    is NetworkResponse.Error -> {
                        emit(NetworkResponse.Error(response.exception))
                    }

                    is NetworkResponse.Success -> {
                        insertPerson(response.result.toPersonEntity())
                        cachedPersonData = getPersonFromDatabase()
                        emit(NetworkResponse.Success(cachedPersonData!!.toPerson()))
                    }

                    NetworkResponse.Loading -> emit(NetworkResponse.Loading)
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

// network'den gelen response'u database modeline çevirmek için kullanılan extension function mapperi
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

// database'den gelen response'u network modeline çevirmek için kullanılan extension function mapperi
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
