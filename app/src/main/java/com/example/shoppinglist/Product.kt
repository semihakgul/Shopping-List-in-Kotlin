package com.example.shoppinglist

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var name: String,
    var price: Double,
    var bought: Boolean,
    var quantity: Int
)