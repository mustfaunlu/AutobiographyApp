package com.mustafaunlu.autobiographyapp.data.database

import androidx.room.Database
import androidx.room.ProvidedTypeConverter
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mustafaunlu.autobiographyapp.data.models.Portfolio
import com.mustafaunlu.autobiographyapp.data.models.Social
import javax.inject.Inject

/**
 * Room kutuphanesi kullanilarak olusturulmus veritabani sinifi.
 */
@TypeConverters(PortfolioConverter::class, SocialConverter::class)
@Database(entities = [PersonEntity::class], version = 1, exportSchema = false)
abstract class PersonDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao
}

/**
 * Room kutuphanesi primitive tipleri destekledigi icin Social ve Portfolio siniflarini
 * String olarak veritabanina kaydetmek icin kullanilan TypeConverter siniflaridir.
 */

@ProvidedTypeConverter
class PortfolioConverter @Inject constructor(private val gson: Gson) {
    @TypeConverter
    fun fromJsonString(value: String): List<Portfolio> {
        val listType = object : TypeToken<List<Portfolio>>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun toJsonString(list: List<Portfolio>): String {
        return gson.toJson(list)
    }
}

@ProvidedTypeConverter
class SocialConverter @Inject constructor(private val gson: Gson) {
    @TypeConverter
    fun fromSocialList(social: List<Social>): String {
        return gson.toJson(social)
    }

    @TypeConverter
    fun toSocialList(socialString: String): List<Social> {
        val type = object : TypeToken<List<Social>>() {}.type
        return gson.fromJson(socialString, type)
    }
}
