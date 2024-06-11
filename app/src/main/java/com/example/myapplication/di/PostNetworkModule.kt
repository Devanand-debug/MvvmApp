package com.example.myapplication.di

import com.example.myapplication.api.ApiService
import com.example.myapplication.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PostNetworkModule {

    @Provides
    @Singleton
    fun ProvideRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun ProvideApiService(retrofit: Retrofit) : ApiService{
        return retrofit.create(ApiService::class.java)
    }
}