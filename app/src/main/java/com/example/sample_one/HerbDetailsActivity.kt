package com.example.sample_one

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HerbDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_herb_details)

        val plant = intent.getParcelableExtra<Plant>("plant")

        val imageView: ImageView = findViewById(R.id.plantImageView)
        val textView: TextView = findViewById(R.id.plantDetailsTextView)

        imageView.setImageResource(plant?.imageResId ?: R.drawable.placeholder)

        textView.text = when (plant?.name) {
            "Neem" -> getString(R.string.neem)
            "Tulsi" -> getString(R.string.tulsi_description)
            "Aloe Vera" -> getString(R.string.aloe_vera_description)
            "Ashwagandha" -> getString(R.string.ashwagandha_description)
            "Brahmi" -> getString(R.string.brahmi_description)
            "Turmeric" -> getString(R.string.turmeric_description)
            else -> "No details available"
        }
    }
}
