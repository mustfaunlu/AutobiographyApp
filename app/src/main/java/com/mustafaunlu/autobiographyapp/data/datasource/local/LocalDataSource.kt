package com.mustafaunlu.autobiographyapp.data.datasource.local

import com.mustafaunlu.autobiographyapp.data.database.PersonEntity

interface LocalDataSource {
    suspend fun insertPerson(person: PersonEntity)

    suspend fun getPerson(): PersonEntity
}
