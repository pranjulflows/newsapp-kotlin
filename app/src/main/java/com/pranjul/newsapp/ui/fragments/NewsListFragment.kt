package com.pranjul.newsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.pranjul.newsapp.R
import com.pranjul.newsapp.databinding.FragmentNewsListBinding


class NewsListFragment : Fragment() {

    private lateinit var binding: FragmentNewsListBinding
    private
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_news_list, container, false);
        return binding.root
    }
}