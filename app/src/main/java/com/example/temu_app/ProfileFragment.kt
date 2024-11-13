package com.example.temu_app

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {

    private lateinit var signInButton: Button
    private lateinit var settingButton: LinearLayout
    private lateinit var messageButton: LinearLayout
    private lateinit var orderButton: LinearLayout
    private lateinit var reviewButton: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Reference the buttons from fragment_profile.xml
        signInButton = view.findViewById(R.id.btn_sign_in)
        settingButton = view.findViewById(R.id.setting_button)
        messageButton = view.findViewById(R.id.message)
        orderButton = view.findViewById(R.id.order)
        reviewButton = view.findViewById(R.id.review)

        // Set the click listener for the sign-in button
        signInButton.setOnClickListener {
            val intent = Intent(activity, Register::class.java)
            startActivity(intent)
        }

        // Set up the click listener for the messages section
        orderButton.setOnClickListener {
            val intent = Intent(activity, OrderActivity::class.java)
            startActivity(intent)
        }

        reviewButton.setOnClickListener {
            val intent = Intent(activity, ReviewActivity::class.java)
            startActivity(intent)
        }

        messageButton.setOnClickListener {
            val intent = Intent(activity, NotificationActivity::class.java)
            startActivity(intent)
        }

        // Set the click listener for the setting button
        settingButton.setOnClickListener {
            val intent = Intent(activity, Setting::class.java)
            startActivity(intent)
        }

        return view
    }
}
