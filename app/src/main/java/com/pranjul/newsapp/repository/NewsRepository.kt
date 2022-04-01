package com.pranjul.newsapp.repository

import com.pranjul.newsapp.base.BaseApiResponse
import com.pranjul.newsapp.base.NetworkResult
import com.pranjul.newsapp.data.NewsDataSource
import com.pranjul.newsapp.data.model.ApiResponse
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class NewsRepository @Inject constructor(private val mainRepoDataSource: NewsDataSource) :
    BaseApiResponse() {

    suspend fun getNewsList(): Flow<NetworkResult<ApiResponse>> {
        return flow {
            emit(safeApiCall { mainRepoDataSource.getNewsList() })
        }.flowOn(Dispatchers.IO)
    }

}