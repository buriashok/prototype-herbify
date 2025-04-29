package com.example.sample_one

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(private val fullList: List<Int>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    private var filteredList = fullList.toMutableList()

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.imageView.setImageResource(filteredList[position])
    }

    override fun getItemCount(): Int = filteredList.size

    fun filter(query: String) {
        filteredList = if (query.isEmpty()) {
            fullList.toMutableList()
        } else {
            fullList.filterIndexed { index, _ ->
                "Herb $index".contains(query, ignoreCase = true)
            }.toMutableList()
        }
        notifyDataSetChanged()
    }
}
