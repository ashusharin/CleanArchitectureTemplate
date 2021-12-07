package com.shusharin.cleanarchitecture.ui.mainScreen.recyclerView

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shusharin.cleanarchitecture.databinding.RvViewholderProductBinding
import com.shusharin.cleanarchitecture.domain.Product
import com.squareup.picasso.Picasso

class Adapter : RecyclerView.Adapter<ProductViewHolder>() {

    var productList = listOf<Product>()
        set(value) {
            val callback = DiffCallback(productList, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = RvViewholderProductBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)

        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        val binding = holder.binding
        Picasso.get().load(product.image).into(binding.imgVh)
        binding.tvTitleVh.text = product.title
        Log.d("Recyclerview", "holder: $position ")
        binding.tvPriceVh.text = StringBuilder("$${product.price} ")
    }

    override fun getItemCount(): Int {
        return productList.size
    }


}