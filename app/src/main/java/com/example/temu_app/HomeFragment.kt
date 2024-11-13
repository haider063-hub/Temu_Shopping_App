package com.example.temu_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: HomePagerAdapter
    private lateinit var searchView: SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        tabLayout = view.findViewById(R.id.tabLayout)
        viewPager2 = view.findViewById(R.id.viewPager2)
        searchView = view.findViewById(R.id.search)

        adapter = HomePagerAdapter(childFragmentManager, lifecycle)
        viewPager2.adapter = adapter

        // Connect TabLayout with ViewPager2
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = when (position) {
                0 -> "All"
                1 -> "Man"
                2 -> "Automotive"
                3 -> "Electronics"
                4 -> "Toy"
                else -> "Tab ${position + 1}"
            }
        }.attach()

        // Set up SearchView listener
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterFragments(newText ?: "")
                return true
            }
        })

        return view
    }

    private fun filterFragments(query: String) {
        // Get the current fragment from ViewPager2
        val currentFragment = getCurrentFragment()
        if (currentFragment is SearchableFragment) {
            currentFragment.filterItems(query)
        }
    }

    private fun getCurrentFragment(): Fragment? {
        return childFragmentManager.findFragmentByTag("f${viewPager2.currentItem}")
    }
}
