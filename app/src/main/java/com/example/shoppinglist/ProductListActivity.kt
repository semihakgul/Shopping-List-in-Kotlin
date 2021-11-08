package com.example.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglist.databinding.ActivityProductListBinding
import androidx.lifecycle.Observer


class ProductListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rv1.layoutManager = LinearLayoutManager(this)    //LayoutManager
        binding.rv1.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))    //ItemDecorator (optional)
        val productViewModel = ProductViewModel(application)

        val adap = ProductAdapter(productViewModel)
        binding.rv1.adapter = adap    //Adapter
        productViewModel.allProducts.observe(this, Observer { products ->
            products?.let{
                adap.setProducts(it)
            }
        })

        binding.bt1.setOnClickListener {
            val product = Product(
                name =binding.et1.text.toString(),
                price =binding.et2.text.toString().toDouble(),
                bought = false,
                quantity = binding.et3.text.toString().toInt()
            )
            productViewModel.insert(product)
            Toast.makeText(
                this,
                "Product: ${product.name} ${product.price} was added.",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.bt1.setOnLongClickListener {
            productViewModel.deleteAll()
            Toast.makeText(
                this,
                "All product records delete.",
                Toast.LENGTH_SHORT
            ).show()
            true
        }

    }
}