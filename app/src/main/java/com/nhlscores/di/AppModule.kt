package com.nhlscores.di

import com.google.gson.GsonBuilder
import com.nhlscores.network.ApiService
import com.nhlscores.network.BasicAuthInterceptor
import com.nhlscores.network.dto.DtoMapper
import com.nhlscores.repository.GamesRepository
import com.nhlscores.repository.GamesRepository_Impl
import com.nhlscores.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideString(): String {
        return "jdfkl"
    }

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        val client = OkHttpClient.Builder()
            .addInterceptor(BasicAuthInterceptor(Constants.token, Constants.password))
            .build()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService::class.java)
    }


    @Singleton
    @Provides
    fun provideGamesRepository(apiService: ApiService): GamesRepository {
        return GamesRepository_Impl(
            apiService,
            DtoMapper()
        )
    }
}