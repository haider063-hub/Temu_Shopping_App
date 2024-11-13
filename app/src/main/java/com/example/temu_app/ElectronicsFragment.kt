// ElectronicsFragment.kt
package com.example.temu_app

import Items_Data
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ElectronicsFragment : Fragment(), SearchableFragment {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recycleViewItemAdapter: RecycleViewItemAdapter
    private var itemList: List<Items_Data> = ItemRepository.electronicItems // Sample electronics items
    private var filteredList: List<Items_Data> = itemList // To store filtered items

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_electronics, container, false)

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 2) // 2 columns
        recyclerView.setHasFixedSize(true)

        // Set up the adapter with item click listener as a lambda
        recycleViewItemAdapter = RecycleViewItemAdapter(itemList) { item ->
            // Handle item click, start DetailedActivity
            val intent = Intent(activity, DetailedActivity::class.java).apply {
                putExtra("title", item.title)
                putExtra("description", item.description)
                putExtra("image", item.image)
                putExtra("price", item.price)
                putExtra("sold", item.sold)
            }
            startActivity(intent) // Start DetailedActivity
        }

        recyclerView.adapter = recycleViewItemAdapter

        return view
    }

    override fun filterItems(query: String) {
        filteredList = if (query.isEmpty()) {
            itemList // No filter applied, show all items
        } else {
            itemList.filter { it.title.contains(query, ignoreCase = true) } // Filter based on the title
        }
        recycleViewItemAdapter.updateList(filteredList) // Update the adapter with the filtered list
    }
}
