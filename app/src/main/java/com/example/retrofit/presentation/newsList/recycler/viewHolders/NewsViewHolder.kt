package com.example.retrofit.presentation.newsList.recycler.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.retrofit.R
import com.example.retrofit.databinding.NewsItemBinding
import com.example.retrofit.domain.models.BaseItem
import com.example.retrofit.domain.models.News
import com.example.retrofit.presentation.newsList.recycler.BaseViewHolder
import com.example.retrofit.presentation.newsList.recycler.clickListeners.ShareClickListener

class NewsViewHolder(
    private val binding: NewsItemBinding,
    private val shareClickListener: ShareClickListener
) : BaseViewHolder(binding.root) {

    companion object {
        const val VIEW_TYPE = 2
        fun newInstance(parent: ViewGroup, shareClickListener: ShareClickListener) = NewsViewHolder(
            NewsItemBinding.bind(LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.news_item,
                    parent,
                    false
                )
            ),
            shareClickListener
        )
    }

    override fun bindItem(baseItem: BaseItem) {
        (baseItem as News).apply {
            binding.newsTitle.text = title
            binding.newsDescription.text = description
            binding.newsAuthor.text = author

            Glide.with(itemView.context)
                .load(urlToImage)
                .into(binding.newsImage)

            binding.share.setOnClickListener {
                shareClickListener.sendNews(url)
            }
        }
    }
}