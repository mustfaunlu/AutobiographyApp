package com.mustafaunlu.autobiographyapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPerson(person: PersonEntity)

    @Query("SELECT * FROM person_table")
    fun getUser(): PersonEntity
}
