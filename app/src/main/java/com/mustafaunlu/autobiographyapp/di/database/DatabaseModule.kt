package com.mustafaunlu.autobiographyapp.di.database

import android.content.Context
import androidx.room.Room
import com.mustafaunlu.autobiographyapp.data.database.PersonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): PersonDatabase {
        return Room.databaseBuilder(
            context,
            PersonDatabase::class.java,
            "person_database",
        ).build()
    }

    @Provides
    fun provideDao(database: PersonDatabase) = database.personDao()
}
