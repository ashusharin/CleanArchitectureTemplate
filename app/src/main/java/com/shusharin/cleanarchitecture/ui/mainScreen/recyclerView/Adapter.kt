package com.shusharin.cleanarchitecture.ui.mainScreen.recyclerView

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shusharin.cleanarchitecture.R
import com.shusharin.cleanarchitecture.domain.Product
import com.squareup.picasso.Picasso

class Adapter : RecyclerView.Adapter<ProductViewHolder>() {

    lateinit var rView: RecyclerView

    var productList = listOf<Product>()
        set(value) {
            val callback = DiffCallback(productList, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        rView = recyclerView
        Log.d("recyclerVertical", rView.layoutManager.toString())
        super.onAttachedToRecyclerView(recyclerView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        // TODO: 08.12.2021 Выяснить, почему если поменять местами условия, все перестает работать
        val layout = when (rView.layoutManager) {
            is GridLayoutManager -> R.layout.rv_viewholder_product_grid
            is LinearLayoutManager -> R.layout.rv_viewholder_product
            else -> throw RuntimeException("Error type layout manager. Unknown view type: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        Log.d("recyclerVertical","layout - ${layout.toString()}" )
        return ProductViewHolder(view)
    }


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        Picasso.get().load(product.image).into(holder.imgVh)
        holder.tvTitleVh.text = product.title
        Log.d("Recyclerview", "holder: $position ")
        holder.tvPriceVh.text = StringBuilder("$${product.price} ")
    }


    override fun getItemCount(): Int {
        return productList.size
    }


}