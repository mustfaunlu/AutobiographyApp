package com.mustafaunlu.autobiographyapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mustafaunlu.autobiographyapp.data.models.Portfolio
import com.mustafaunlu.autobiographyapp.data.models.Social

@Entity(tableName = "person_table")
data class PersonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val about: String,
    val age: Int,
    val description: String,
    val image: String,
    val job: String,
    val name: String,
    val portfolio: Array<Portfolio>,
    val social: Array<Social>,
    val surname: String,
)
