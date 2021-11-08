package com.example.shoppinglist

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {

    @Query("SELECT * FROM product")
    fun getProducts(): LiveData<List<Product>>

    @Insert
    fun insert(product: Product)

    @Delete
    fun delete(product: Product)

    @Query("DELETE FROM product")
    fun deleteAll()

}