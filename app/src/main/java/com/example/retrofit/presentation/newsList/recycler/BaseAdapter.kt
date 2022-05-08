package com.example.retrofit.presentation.newsList.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.domain.models.BaseItem
import com.example.retrofit.domain.models.Date
import com.example.retrofit.domain.models.News
import com.example.retrofit.domain.models.TotalResult
import com.example.retrofit.presentation.newsList.recycler.clickListeners.ShareClickListener
import com.example.retrofit.presentation.newsList.recycler.viewHolders.DateViewHolder
import com.example.retrofit.presentation.newsList.recycler.viewHolders.NewsViewHolder
import com.example.retrofit.presentation.newsList.recycler.viewHolders.TotalResultsViewHolder

class BaseAdapter(
    private val shareClickListener: ShareClickListener
) : RecyclerView.Adapter<BaseViewHolder>() {

    private var items = listOf<BaseItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            DateViewHolder.VIEW_TYPE -> DateViewHolder.newInstance(parent)
            NewsViewHolder.VIEW_TYPE -> NewsViewHolder.newInstance(parent, shareClickListener)
            TotalResultsViewHolder.VIEW_TYPE -> TotalResultsViewHolder.newInstance(parent)
            else -> throw IllegalStateException("Wrong ViewHolder type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is Date -> DateViewHolder.VIEW_TYPE
            is News -> NewsViewHolder.VIEW_TYPE
            is TotalResult -> TotalResultsViewHolder.VIEW_TYPE
            else -> 0
        }
    }

    fun setItems(data: List<BaseItem>) {
        items = data
        notifyDataSetChanged()
    }
}