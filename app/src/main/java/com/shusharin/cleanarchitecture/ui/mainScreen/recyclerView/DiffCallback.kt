package com.shusharin.cleanarchitecture.ui.mainScreen.recyclerView

import androidx.recyclerview.widget.DiffUtil
import com.shusharin.cleanarchitecture.domain.Product

class DiffCallback(
    private val oldList: List<Product>,
    private val newList: List<Product>
) :DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val olditem = oldList[oldItemPosition]
        val newitem = newList[newItemPosition]
        return olditem.id == newitem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val olditem =oldList[oldItemPosition]
        val newitem =newList[newItemPosition]
        return  olditem == newitem
    }

}