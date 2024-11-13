// AllFragment.kt
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

class AllFragment : Fragment(), SearchableFragment {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recycleViewItemAdapter: RecycleViewItemAdapter
    private var itemList: List<Items_Data> = ItemRepository.allItems

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_all, container, false)

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 2) // 2 columns
        recyclerView.setHasFixedSize(true)
0
        // Set up the adapter with item click listener
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
        recycleViewItemAdapter.filter(query)
    }
}
