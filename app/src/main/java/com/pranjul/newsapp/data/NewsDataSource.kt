package com.pranjul.newsapp.data

import com.pranjul.newsapp.BuildConfig
import com.pranjul.newsapp.data.network.ApiService
import javax.inject.Inject

class NewsDataSource @Inject constructor(private val api: ApiService) {
    suspend fun getNewsList() = api.getNews("us", BuildConfig.NewsApiKey)
}