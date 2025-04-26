package com.example.sample_one

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HerbDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_herb_details)

        val herbName = intent.getStringExtra("HERB_NAME")
        val herbNameTextView = findViewById<TextView>(R.id.herbNameTextView)

        herbNameTextView.text = herbName ?: "Herb Details"
    }
}
