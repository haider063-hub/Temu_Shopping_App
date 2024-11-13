package com.example.temu_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button

class Register : AppCompatActivity() {
    private lateinit var emailButton: Button
    private lateinit var phoneButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        // Initialize the buttons
        emailButton = findViewById(R.id.email_button)  // Ensure this ID matches your layout
        phoneButton = findViewById(R.id.phone_button)  // Ensure this ID matches your layout

        // Set click listener for the email button
        emailButton.setOnClickListener {
            val intent = Intent(this, Email_Register::class.java)  // Change to your target activity
            startActivity(intent)  // Start the Email_Register activity
        }

        // Set click listener for the phone button
        phoneButton.setOnClickListener {
            val intent = Intent(this, Sign_In::class.java)  // Change to your target activity
            startActivity(intent)  // Start the SignIn activity
        }

        // Handle window insets for edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
