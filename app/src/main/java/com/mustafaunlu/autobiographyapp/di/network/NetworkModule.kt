package com.mustafaunlu.autobiographyapp.di.network

import com.google.gson.Gson
import com.mustafaunlu.autobiographyapp.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Network islemleri icin gerekli olan Retrofit kutuphanesi bagimliliklarini
 * saglamak icin kullanilan Hilt Dependency Injection kutuphanesi ile olusturulmus modul.
 */
private const val BASE_URL = "https://raw.githubusercontent.com/mustfaunlu/mockdb/main/"

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideApiService(gson: Gson): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService::class.java)
    }
}
