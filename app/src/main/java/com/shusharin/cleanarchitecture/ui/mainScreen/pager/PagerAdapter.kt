package com.shusharin.cleanarchitecture.ui.mainScreen.pager

import android.graphics.drawable.Drawable
import android.opengl.Visibility
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shusharin.cleanarchitecture.R
import com.shusharin.cleanarchitecture.ui.mainScreen.recyclerView.ProductViewHolder

class PagerAdapter() : RecyclerView.Adapter<PagerAdapter.ViewPagerViewHolder>() {

    val images = listOf(R.drawable.promotion_image, R.drawable.recomended_image)

    class ViewPagerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.image_start)
        val titleUp = view.findViewById<TextView>(R.id.title_up)
        val titleDown = view.findViewById<TextView>(R.id.title_down)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view_start_pager, parent, false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val curImage = images[position]
        if (position == 1) {
            holder.titleUp.visibility = View.GONE
            holder.titleDown.visibility = View.GONE
        }
        holder.image.setImageResource(curImage)
    }

    override fun getItemCount(): Int {
        return images.size
    }
}