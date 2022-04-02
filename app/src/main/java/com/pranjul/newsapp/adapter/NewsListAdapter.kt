package com.pranjul.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pranjul.newsapp.BR
import com.pranjul.newsapp.data.model.Article
import com.pranjul.newsapp.databinding.ItemNewsLayoutBinding

class NewsListAdapter : RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {
    private var itemsList: ArrayList<Article>? = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemNewsLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        itemsList?.let { holder.bind(it[position]) }
    }

    class ViewHolder(var binding: ItemNewsLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.setVariable(BR.article, article)
        }
    }

    override fun getItemCount() = itemsList?.size ?: 0
    fun addItems(itemList: ArrayList<Article>?) {
//        if (itemList == null) itemsList = ArrayList()
        itemList?.let {
            for (i in itemList.indices) {
                val item: Article = itemList[i]
                if (!itemsList!!.contains(item)) itemsList!!.add(item)
            }
        }
        notifyDataSetChanged()
    }
}