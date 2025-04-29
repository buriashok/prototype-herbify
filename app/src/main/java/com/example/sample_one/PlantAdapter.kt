package com.example.sample_one

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlantAdapter(
    private val plantList: List<Plant>,
    private val onItemClick: (Plant) -> Unit
) : RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {

    inner class PlantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val plantImage: ImageView = itemView.findViewById(R.id.plantImage)
        val plantName: TextView = itemView.findViewById(R.id.plantName)

        fun bind(plant: Plant) {
            plantImage.setImageResource(plant.imageResId)
            plantName.text = plant.name
            itemView.setOnClickListener {
                onItemClick(plant)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_plant, parent, false)
        return PlantViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        holder.bind(plantList[position])
    }

    override fun getItemCount(): Int = plantList.size
}
