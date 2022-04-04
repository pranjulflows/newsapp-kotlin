package com.pranjul.newsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.pranjul.newsapp.R
import com.pranjul.newsapp.databinding.FragmentNewsListBinding
import com.pranjul.newsapp.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NewsListFragment : Fragment() {

    private lateinit var binding: FragmentNewsListBinding
    private val viewModel by viewModels<NewsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_news_list, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.getNewsList()
        return binding.root
    }
}