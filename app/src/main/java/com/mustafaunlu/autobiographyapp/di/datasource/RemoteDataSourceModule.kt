package com.mustafaunlu.autobiographyapp.di.datasource

import com.mustafaunlu.autobiographyapp.data.datasource.remote.RemoteDataSource
import com.mustafaunlu.autobiographyapp.data.datasource.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
/**
 * Remote Data Source bagimliliklarini saglamak icin kullanilan
 * Hilt Dependency Injection kutuphanesi ile olusturulmus modul.
 */
@Module
@InstallIn(ViewModelComponent::class)
abstract class RemoteDataSourceModule {
    @Binds
    @ViewModelScoped
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}
