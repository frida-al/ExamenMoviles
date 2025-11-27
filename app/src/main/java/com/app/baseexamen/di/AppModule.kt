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
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Properties

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(@ApplicationContext context: Context): Retrofit {
        val properties = Properties()
        val inputStream = context.assets.open("local.properties")
        properties.load(inputStream)
        val apiKey = properties.getProperty("apiKey") ?: throw IllegalArgumentException("API key not found")

        val interceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("X-Api-Key", apiKey)
                .build()
            chain.proceed(request)
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://api.api-ninjas.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
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
