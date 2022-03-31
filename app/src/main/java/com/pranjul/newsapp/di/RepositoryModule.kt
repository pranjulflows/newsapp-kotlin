package com.macamps.kotlinflows.di

import com.macamps.kotlinflows.data.MainDbSource
import com.macamps.kotlinflows.data.MainRepoDataSource
import com.macamps.kotlinflows.data.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(mainRepoDataSource: MainRepoDataSource, mainDbSource: MainDbSource) =
        MainRepository(mainRepoDataSource, mainDbSource)

}