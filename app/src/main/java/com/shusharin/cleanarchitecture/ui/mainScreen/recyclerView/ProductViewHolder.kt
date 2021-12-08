package com.shusharin.cleanarchitecture.ui.mainScreen.recyclerView

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shusharin.cleanarchitecture.R

class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvTitleVh = view.findViewById<TextView>(R.id.tv_title_vh)
    val tvPriceVh = view.findViewById<TextView>(R.id.tv_price_vh)
    val imgVh = view.findViewById<ImageView>(R.id.img_vh)
}
