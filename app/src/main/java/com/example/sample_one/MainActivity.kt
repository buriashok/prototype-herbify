package com.example.sample_one

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.topAppBar)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(android.R.drawable.ic_menu_sort_by_size)
            title = "Herbify"
        }

        viewPager = findViewById(R.id.imageSlider)

        val images = listOf(
            R.drawable.image_sider_two, // your image in drawable folder
            R.drawable.image_sider_two,
            R.drawable.image_sider_three
        )

        val adapter = ImageAdapter(images)
        viewPager.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> true
            R.id.action_search -> true
            R.id.action_camera -> true
            R.id.action_more -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
