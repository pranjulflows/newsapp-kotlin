package com.pranjul.newsapp.viewModels

import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.pranjul.newsapp.adapter.NewsListAdapter
import com.pranjul.newsapp.data.model.Article
import com.pranjul.newsapp.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel() {


    private val mutableflow = MutableStateFlow<ArrayList<Article>>(arrayListOf())
    val articlesFlow: StateFlow<ArrayList<Article>> = mutableflow
    private val error = MutableStateFlow("")
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun getNewsList() {
        viewModelScope.launch {
            newsRepository.getNewsList().onStart {
                _isLoading.emit(true)
            }.catch {
                _isLoading.emit(false)
            }.collect {
                _isLoading.emit(false)
                mutableflow.emit(it.data?.articles as ArrayList<Article>)
            }

        }
    }

    companion object {
        @BindingAdapter("articles")
        @JvmStatic
        fun RecyclerView.bindRecyclerView(data: ArrayList<Article>?) {
            val referencesAdapter = NewsListAdapter()
            this.apply {
                adapter = referencesAdapter
            }
            data.let { referencesAdapter.addItems(it) }
        }
    }

}