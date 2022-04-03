package com.pranjul.newsapp.viewModels

import android.net.Uri
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.browser.customtabs.CustomTabsIntent
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pranjul.newsapp.adapter.NewsListAdapter
import com.pranjul.newsapp.data.model.Article
import com.pranjul.newsapp.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel() {


    private val mutableflow = MutableStateFlow<ArrayList<Article>>(arrayListOf())
    val articlesFlow: StateFlow<ArrayList<Article>> = mutableflow
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun getNewsList() {
        viewModelScope.launch {
            newsRepository.getNewsList().onStart {
                _isLoading.emit(true)
            }.catch {
                Log.e("TAG", "getNewsList: ${it.localizedMessage}")
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

        @BindingAdapter("src:image")
        @JvmStatic
        fun ImageView.setImage(url: String?) {
            url?.let { Glide.with(this).load(url).into(this) }
        }

        @BindingAdapter("showDate")
        @JvmStatic
        fun TextView.setPublishedDate(publishedDate: String) {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
            val outputFormat = SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.ENGLISH)
            val date: Date? = inputFormat.parse(publishedDate)
            val formattedDate: String = outputFormat.format(date!!)
            text = formattedDate
        }

        @BindingAdapter("showNews")
        @JvmStatic
        fun ConstraintLayout.showNews(url: String) {
            setOnClickListener {
                val builder = CustomTabsIntent.Builder()
                val customTabsIntent = builder.build()
                customTabsIntent.launchUrl(it.context, Uri.parse(url))
            }

        }

    }

}