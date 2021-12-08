package com.shusharin.cleanarchitecture.ui.mainScreen.recyclerView.category

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import com.shusharin.cleanarchitecture.R
import com.shusharin.cleanarchitecture.databinding.RvCategoryViewholderBinding

class CategoryAdapter : RecyclerView.Adapter<CategoryViewHolder>() {

    var categoryList = arrayOfNulls<Int>(5)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = RvCategoryViewholderBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)

        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        getView(position, holder)

    }

    override fun getItemCount(): Int {
        Log.d("CategoryAdapter", "${categoryList.size}")
        return categoryList.size
    }

    // TODO: 07.12.2021 Переделать этот ужас
    private fun getView(position: Int, holder: CategoryViewHolder) {
        val binding = holder.binding
        when (position) {
            0 -> binding.categoryImage.setImageResource(R.drawable.ic_shirt)
            1 -> binding.categoryImage.setImageResource(R.drawable.ic_dress)
            2 -> binding.categoryImage.setImageResource(R.drawable.ic_man_bag)
            3 -> binding.categoryImage.setImageResource(R.drawable.ic_woman_bag)
            4 -> binding.categoryImage.setImageResource(R.drawable.ic_man_shoes)
            5 -> binding.categoryImage.setImageResource(R.drawable.ic_woman_shoes)

        }
        when (position) {
            0 -> binding.categoryRvTv.text = "Футболки"
            1 -> binding.categoryRvTv.text = "Платья"
            2 -> binding.categoryRvTv.text = "Сумки"
            3 -> binding.categoryRvTv.text = "Сумки"
            4 -> binding.categoryRvTv.text = "Обувь"
            5 -> binding.categoryRvTv.text = "Обувь"
        }
    }


}