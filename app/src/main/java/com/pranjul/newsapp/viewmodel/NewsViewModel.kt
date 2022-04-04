package com.pranjul.newsapp.viewmodel

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pranjul.newsapp.R
import com.pranjul.newsapp.adapter.NewsListAdapter
import com.pranjul.newsapp.app.AppClass
import com.pranjul.newsapp.data.model.Article
import com.pranjul.newsapp.extension.Extensions.toast
import com.pranjul.newsapp.repository.NewsRepository
import com.pranjul.newsapp.utils.Utils.getConnectionType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel() {


    private val mutableFlow = MutableStateFlow<ArrayList<Article>>(arrayListOf())
    val articlesFlow: StateFlow<ArrayList<Article>> = mutableFlow
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun getNewsList() {
        viewModelScope.launch {
            if (getConnectionType() != 0) {
                newsRepository.getNewsList().onStart {
                    _isLoading.emit(true)
                }.catch {
                    Log.e("TAG", "getNewsList: ${it.localizedMessage}")
                    _isLoading.emit(false)
                }.collect {
                    _isLoading.emit(false)
                    mutableFlow.emit(it.data?.articles as ArrayList<Article>)
                }
            } else AppClass.instance.toast(AppClass.instance.getString(R.string.no_internet_msg))


        }

    }

    companion object {
        @BindingAdapter("articles")
        @JvmStatic
        fun RecyclerView.bindRecyclerView(data: ArrayList<Article>?) {
            val referencesAdapter = NewsListAdapter()

            apply { adapter = referencesAdapter }

            data.let { referencesAdapter.addItems(it) }
        }

        @BindingAdapter("src:image")
        @JvmStatic
        fun ImageView.setImage(url: String?) {


            url?.let {
                Glide.with(this).load(url)
                    .error(ContextCompat.getDrawable(context, R.drawable.placeholder)).into(this)
            }
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


    }

}