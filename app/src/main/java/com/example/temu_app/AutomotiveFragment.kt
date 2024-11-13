// AutomotiveFragment.kt
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

class AutomotiveFragment : Fragment(), SearchableFragment {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recycleViewItemAdapter: RecycleViewItemAdapter
    private var itemList: List<Items_Data> = ItemRepository.automotiveItems
    private var filteredList: List<Items_Data> = itemList

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_automotive, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
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
            startActivity(intent)
        }

        recyclerView.adapter = recycleViewItemAdapter

        return view
    }

    override fun filterItems(query: String) {
        filteredList = if (query.isEmpty()) {
            itemList
        } else {
            itemList.filter { it.title.contains(query, ignoreCase = true) }
        }
        recycleViewItemAdapter.updateList(filteredList)
    }
}
