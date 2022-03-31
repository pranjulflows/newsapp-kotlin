package com.pranjul.newsapp.di

import com.pranjul.newsapp.BuildConfig
import com.pranjul.newsapp.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder().client(okHttpClient).baseUrl(
        BuildConfig.API_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder().addNetworkInterceptor(
        HttpLoggingInterceptor().setLevel(
            HttpLoggingInterceptor.Level.BODY
        )
    ).build()


    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

}