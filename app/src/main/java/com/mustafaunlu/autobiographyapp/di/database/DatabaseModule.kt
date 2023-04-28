package com.mustafaunlu.autobiographyapp.di.database

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.mustafaunlu.autobiographyapp.data.database.PersonDatabase
import com.mustafaunlu.autobiographyapp.data.database.PortfolioConverter
import com.mustafaunlu.autobiographyapp.data.database.SocialConverter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 * Database bagimliliklarini saglamak icin kullanilan
 * Hilt Dependency Injection kutuphanesi ile olusturulmus modul.
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun provideDatabase(@ApplicationContext context: Context, gson: Gson): PersonDatabase {
        return Room.databaseBuilder(
            context,
            PersonDatabase::class.java,
            "person_database",

        ).addTypeConverter(PortfolioConverter(gson))
            .addTypeConverter(SocialConverter(gson))
            .build()
    }

    @Provides
    fun provideDao(database: PersonDatabase) = database.personDao()

    @Provides
    fun providePortfolioConverter(): PortfolioConverter {
        return PortfolioConverter(Gson())
    }

    @Provides
    fun provideSocialConverter(): SocialConverter {
        return SocialConverter(Gson())
    }
}
