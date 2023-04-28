package com.mustafaunlu.autobiographyapp.di.repository

import com.mustafaunlu.autobiographyapp.data.repository.PersonRepository
import com.mustafaunlu.autobiographyapp.data.repository.PersonRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
/**
 * Repository sinifi bagimliliklarini saglamak icin kullanilan
 * Hilt Dependency Injection kutuphanesi ile olusturulmus modul.
 */
@Module
@InstallIn(ViewModelComponent::class)
abstract class PersonRepositoryModule {
    @Binds
    @ViewModelScoped
    abstract fun bindPersonRepository(personRepositoryImpl: PersonRepositoryImpl): PersonRepository
}
