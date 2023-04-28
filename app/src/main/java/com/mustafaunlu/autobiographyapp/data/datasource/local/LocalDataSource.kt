package com.mustafaunlu.autobiographyapp.data.datasource.local

import com.mustafaunlu.autobiographyapp.data.database.PersonEntity

/**
 * Local Data Source; repository sinifina local database'e depolanan verileri
 * saglamak icin kullanilan single source of truth ilkesi amaci ile kullanilan interfacedir.
 */
interface LocalDataSource {
    suspend fun insertPerson(person: PersonEntity)

    suspend fun getPerson(): PersonEntity
}
