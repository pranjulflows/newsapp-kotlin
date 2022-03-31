package com.pranjul.newsapp.di


import com.pranjul.newsapp.data.NewsDataSource
import com.pranjul.newsapp.repository.NewsRepository
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
    fun provideMainRepository(mainRepoDataSource: NewsDataSource) =
        NewsRepository(mainRepoDataSource)

}