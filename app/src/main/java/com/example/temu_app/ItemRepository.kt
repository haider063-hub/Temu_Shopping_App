package com.example.temu_app

import Items_Data

object ItemRepository {
    val manItems = listOf(
        Items_Data("Men's Watch", "$50.00", "100 Sold", R.drawable.newwatch, "Stylish wristwatch for men."),
        Items_Data("Men's Jacket", "$80.00", "200 Sold", R.drawable.jacket, "Warm and trendy jacket for winter.")
    )

    val electronicItems = listOf(
        Items_Data("Wireless Earbuds", "$25.00", "300 Sold", R.drawable.earbuds, "High-quality sound with Bluetooth."),
        Items_Data("Smartphone", "$300.00", "150 Sold", R.drawable.smartphone, "Latest model with 64MP camera."),
        Items_Data("Laptop", "$700.00", "60 Sold", R.drawable.laptop, "Lightweight laptop with powerful specs.")
    )

    val automotiveItems = listOf(
        Items_Data("Car Vacuum Cleaner", "$35.00", "120 Sold", R.drawable.carvaccum, "Compact vacuum cleaner for cars."),
        Items_Data("Car Phone Holder", "$15.00", "250 Sold", R.drawable.phoneholder, "Hands-free phone holder for safe driving.")
    )

    val toyItems = listOf(
        Items_Data("Remote Control Car", "$20.00", "400 Sold", R.drawable.remotecar, "Fun remote-controlled toy car."),
        Items_Data("Building Blocks Set", "$30.00", "300 Sold", R.drawable.block, "Educational building blocks for kids."),
        Items_Data("Dollhouse", "$40.00", "200 Sold", R.drawable.dollhouse, "Miniature dollhouse with accessories.")
    )

    // Combine all items into a single list
    val allItems: List<Items_Data> = manItems + electronicItems + automotiveItems + toyItems
}
