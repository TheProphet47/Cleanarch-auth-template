package com.freesia.homeownersnotices.core.platform

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.freesia.homeownersnotices.core.extension.inflate

class CommonRecyclerAdapter<Data>(
    @LayoutRes private val itemLayoutId: Int,
    startData: List<Data>? = null,
    private val onBind: (itemView: View, data: Data) -> Unit
) : RecyclerView.Adapter<CommonRecyclerAdapter<Data>.ItemVh>() {

    var listData: List<Data> = startData ?: emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVh {

        return ItemVh(parent.inflate(itemLayoutId), onBind)
    }

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ItemVh, position: Int) {
        holder.onBind(holder.itemView, listData[position])
    }

    inner class ItemVh(itemView: View, val onBind: (View, Data) -> Unit) :
        RecyclerView.ViewHolder(itemView)
}
