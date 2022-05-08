package com.example.retrofit.presentation.newsList.recycler.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.retrofit.R
import com.example.retrofit.domain.models.BaseItem
import com.example.retrofit.domain.models.TotalResult
import com.example.retrofit.presentation.newsList.recycler.BaseViewHolder

class TotalResultsViewHolder(itemView: View) : BaseViewHolder(itemView) {
    companion object {
        const val VIEW_TYPE = 3
        fun newInstance(parent: ViewGroup) = TotalResultsViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.total_results_item,
                parent,
                false
            )
        )
    }

    private val totalResultsTextView by lazy {
        itemView.findViewById<TextView>(R.id.totalResults)
    }
    override fun bindItem(baseItem: BaseItem) {
        totalResultsTextView.text = (baseItem as TotalResult).totalResult
    }

}