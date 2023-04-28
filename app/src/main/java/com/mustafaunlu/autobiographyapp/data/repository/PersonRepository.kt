package com.mustafaunlu.autobiographyapp.data.repository

import com.mustafaunlu.autobiographyapp.data.NetworkResponse
import com.mustafaunlu.autobiographyapp.data.database.PersonEntity
import com.mustafaunlu.autobiographyapp.data.models.Person
import kotlinx.coroutines.flow.Flow

/**
 * Repository; uygulama icerisinde kullanilan verilerin kaynagini belirlemek ve onalari
 * yonetmek icin kullanilan interfacedir. Ayrica repository veri degisikliklerini merkezilestirir,
 * local ve remote veri kaynaklarini birbirinden ayirir ve yonetir, veri kaynaklarini uygulamanin
 * geri kalanindan soyutlar ve verileri uygulamanin geri kalanina Viewmodel araciligiyla yayar.
 */
interface PersonRepository {
    fun getPerson(): Flow<NetworkResponse<Person>>
    suspend fun getPersonFromDatabase(): PersonEntity
    suspend fun insertPerson(person: PersonEntity)
}
