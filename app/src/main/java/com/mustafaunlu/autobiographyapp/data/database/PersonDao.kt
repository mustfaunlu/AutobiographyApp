package com.mustafaunlu.autobiographyapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Room kutuphanesi ile olusturulmus veritabani icin DAO (Data Access Object) sinifi.
 * Veritabanina erisim icin kullanilan fonksiyonlari icerir.
 */
@Dao
interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPerson(person: PersonEntity)

    @Query("SELECT * FROM person_table")
    fun getUser(): PersonEntity
}
