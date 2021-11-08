package com.example.shoppinglist

class ProductRepo(private val productDao: ProductDao){

    val allProducts = productDao.getProducts()

    fun insert(product: Product) = productDao.insert(product)

    fun delete(product: Product) = productDao.delete(product)

    fun deleteAll() = productDao.deleteAll()

}