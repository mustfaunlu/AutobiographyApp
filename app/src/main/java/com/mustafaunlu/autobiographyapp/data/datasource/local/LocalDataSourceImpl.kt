package com.mustafaunlu.autobiographyapp.data.datasource.local

import com.mustafaunlu.autobiographyapp.data.database.PersonDao
import com.mustafaunlu.autobiographyapp.data.database.PersonEntity
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val personDao: PersonDao) : LocalDataSource {
    override suspend fun insertPerson(person: PersonEntity) {
        personDao.insertPerson(person)
    }

    override suspend fun getPerson(): PersonEntity {
        return personDao.getUser()
    }
}
