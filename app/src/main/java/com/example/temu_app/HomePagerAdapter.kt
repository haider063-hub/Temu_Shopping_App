package com.example.temu_app

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomePagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 5 // Number of tabs
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllFragment() // Replace with your fragment for the first tab
            1 -> ManFragment() // Replace with your fragment for the second tab
            2 -> AutomotiveFragment() // Replace with your fragment for the third tab
            3 -> ElectronicsFragment() // Replace with your fragment for the fourth tab
            4 -> ToyFragment() // Replace with your fragment for the fifth tab
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}
