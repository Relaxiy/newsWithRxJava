package com.example.retrofit.presentation.newsList.recycler.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.retrofit.R
import com.example.retrofit.databinding.DateItemBinding
import com.example.retrofit.domain.models.BaseItem
import com.example.retrofit.domain.models.Date
import com.example.retrofit.presentation.newsList.recycler.BaseViewHolder

class DateViewHolder(private val binding: DateItemBinding) : BaseViewHolder(binding.root) {
    companion object{
        const val VIEW_TYPE = 1
        fun newInstance(parent: ViewGroup) = DateViewHolder(
            DateItemBinding.bind(LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.date_item,
                    parent,
                    false
                )
            )
        )
    }

    override fun bindItem(baseItem: BaseItem) {
        (baseItem as Date).apply {
            binding.date.text = newsDate
        }
    }
}