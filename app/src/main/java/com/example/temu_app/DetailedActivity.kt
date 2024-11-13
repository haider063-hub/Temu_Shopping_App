// DetailedActivity.kt
package com.example.temu_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.temu_app.databinding.ActivityDetailedBinding

class DetailedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve data from intent
        val title = intent.getStringExtra("title") ?: "No Title"
        val description = intent.getStringExtra("description") ?: "No Description"
        val imageRes = intent.getIntExtra("image", 0)
        val price = intent.getStringExtra("price") ?: "N/A"
        val sold = intent.getIntExtra("sold", 0)

        // Set data to views
        binding.productImage.setImageResource(imageRes)
        binding.productTitle.text = title
        binding.productDescription.text = description
        binding.productPrice.text = "Price: $price"
        binding.productSold.text = "$sold Sold"
    }
}
