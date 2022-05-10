package com.example.retrofit.presentation.newsList.recycler.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.retrofit.R
import com.example.retrofit.databinding.TotalResultsItemBinding
import com.example.retrofit.domain.models.BaseItem
import com.example.retrofit.domain.models.TotalResult
import com.example.retrofit.presentation.newsList.recycler.BaseViewHolder

class TotalResultsViewHolder(private val binding: TotalResultsItemBinding) : BaseViewHolder(binding.root) {
    companion object {
        const val VIEW_TYPE = 3
        fun newInstance(parent: ViewGroup) = TotalResultsViewHolder (
            TotalResultsItemBinding.bind(LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.total_results_item,
                    parent,
                    false
                )
            )
        )
    }

    override fun bindItem(baseItem: BaseItem) {
        binding.totalResults.text = (baseItem as TotalResult).totalResult
    }

}