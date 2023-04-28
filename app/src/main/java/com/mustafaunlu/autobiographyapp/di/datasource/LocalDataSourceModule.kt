package com.mustafaunlu.autobiographyapp.di.datasource

import com.mustafaunlu.autobiographyapp.data.datasource.local.LocalDataSource
import com.mustafaunlu.autobiographyapp.data.datasource.local.LocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
/**
 * Local Data Source bagimliliklarini saglamak icin kullanilan
 * Hilt Dependency Injection kutuphanesi ile olusturulmus modul.
 */
@Module
@InstallIn(ViewModelComponent::class)
abstract class LocalDataSourceModule {
    @Binds
    @ViewModelScoped
    abstract fun bindLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource
}
