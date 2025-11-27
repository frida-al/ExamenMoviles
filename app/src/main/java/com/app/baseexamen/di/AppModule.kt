package com.app.baseexamen.di

import android.content.Context
import com.app.baseexamen.data.remote.api.BaseApi
import com.app.baseexamen.data.repository.BaseRepositoryImpl
import com.app.baseexamen.domain.repository.BaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// di/AppModule.kt
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideBaseApi(retrofit: Retrofit): BaseApi {
        return retrofit.create(BaseApi::class.java)
    }

    @Provides
    @Singleton
    fun provideBaseRepository(
        api: BaseApi
    ): BaseRepository {
        return BaseRepositoryImpl(api)
    }
}