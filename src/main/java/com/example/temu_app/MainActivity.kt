package com.example.temu_app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.temu_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load the default fragment (Home)
        replaceFragment(Home())

        // Handle navigation item clicks
        binding.bottomNavigationView.setOnItemSelectedListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.home -> replaceFragment(Home())
                R.id.cart -> replaceFragment(Cart())
                R.id.category -> replaceFragment(Category())
                R.id.profile -> replaceFragment(Profile())
            }
            true
        }

        setupTermsAndPrivacyLinks()
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }

    private fun setupTermsAndPrivacyLinks() {
        val termsTextView = findViewById<TextView>(R.id.terms_text_view)

        // Create a spannable string for the terms and privacy links
        val spannableString = SpannableString(getString(R.string.by_continuing_you_agree_to_our_terms_of_use_and_privacy_n_policy))

        // Define clickable spans for "terms of use" and "privacy policy"
        val termsClickable = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.temu.com/terms-of-use.html"))
                try {
                    startActivity(browserIntent)
                } catch (e: Exception) {
                    Toast.makeText(this@MainActivity, "Error opening link", Toast.LENGTH_SHORT).show()
                }
            }
        }
        val privacyClickable = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.temu.com/privacy-and-cookie-policy.html"))
                try {
                    startActivity(browserIntent)
                } catch (e: Exception) {
                    Toast.makeText(this@MainActivity, "Error opening link", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Apply spans to text
        spannableString.setSpan(UnderlineSpan(), 32, 44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE) // "terms of use"
        spannableString.setSpan(termsClickable, 32, 44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(ForegroundColorSpan(ContextCompat.getColor(this, R.color.blue)), 32, 44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        spannableString.setSpan(UnderlineSpan(), 49, 65, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE) // "privacy policy"
        spannableString.setSpan(privacyClickable, 49, 65, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(ForegroundColorSpan(ContextCompat.getColor(this, R.color.blue)), 49, 65, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        termsTextView.text = spannableString
        termsTextView.movementMethod = LinkMovementMethod.getInstance()
    }
}
