// RecycleViewItemAdapter.kt
package com.example.temu_app

import Items_Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleViewItemAdapter(
    private var itemList: List<Items_Data>,
    private val itemClickListener: (Items_Data) -> Unit // Lambda function to handle clicks
) : RecyclerView.Adapter<RecycleViewItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productName: TextView = itemView.findViewById(R.id.productName)
        val productImage: ImageView = itemView.findViewById(R.id.productImage)
        val productDescription: TextView = itemView.findViewById(R.id.productDescription)
        val productPrice: TextView = itemView.findViewById(R.id.productPrice)
        val productQuantity: TextView = itemView.findViewById(R.id.productQuantity)

        init {
            itemView.setOnClickListener {
                itemClickListener(itemList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_list_items, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.productName.text = item.title
        holder.productImage.setImageResource(item.image)
        holder.productDescription.text = item.description
        holder.productPrice.text = "Price: ${item.price}"
        holder.productQuantity.text = "${item.sold} Sold"
    }

    override fun getItemCount(): Int = itemList.size

    fun updateList(newList: List<Items_Data>) {
        itemList = newList
        notifyDataSetChanged()
    }

    fun filter(query: String) {
        val filteredList = if (query.isEmpty()) {
            ItemRepository.allItems
        } else {
            ItemRepository.allItems.filter { it.title.contains(query, ignoreCase = true) }
        }
        updateList(filteredList)
    }
}
