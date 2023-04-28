package com.mustafaunlu.autobiographyapp.data.datasource.remote

import com.mustafaunlu.autobiographyapp.data.NetworkResponse
import com.mustafaunlu.autobiographyapp.data.models.Person

/**
 * Remote Data Source; repository sinifina network'den gelen verileri
 * saglamak icin kullanilan single source of truth ilkesi amaci ile kullanilan interfacedir.
 */
interface RemoteDataSource {
    suspend fun getPersonData(): NetworkResponse<Person>
}
