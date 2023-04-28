package com.mustafaunlu.autobiographyapp.di.gson

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/**
 * Networkden gelen Json verilerini objelere convert etmek amaci ile kullanilan Gson kutuphanesi bagimliliklarini
 * saglamak icin kullanilan Hilt Dependency Injection kutuphanesi ile olusturulmus modul.
 */
@Module
@InstallIn(SingletonComponent::class)
object GsonModule {
    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }
}
