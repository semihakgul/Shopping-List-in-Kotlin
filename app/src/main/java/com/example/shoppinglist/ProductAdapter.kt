package com.example.shoppinglist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.databinding.ListElementBinding

class ProductAdapter(private val productViewModel: ProductViewModel) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var listOfProducts = emptyList<Product>()

    class ProductViewHolder(val binding: ListElementBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListElementBinding.inflate(inflater)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holderProduct: ProductViewHolder, position: Int) {
        val currentProduct = listOfProducts[position]
        holderProduct.binding.rvtv1.text = currentProduct.id.toString()
        holderProduct.binding.rvtv2.text = currentProduct.name
        holderProduct.binding.rvtv3.text = currentProduct.price.toString() + "$"
        holderProduct.binding.rvtv4.text = "x" + currentProduct.quantity.toString()
        holderProduct.binding.rvcb1.isChecked = currentProduct.bought
        holderProduct.binding.rvbt1.setOnClickListener {
            productViewModel.delete(currentProduct)
            Toast.makeText(
                holderProduct.binding.root.context,
                "Product with id:${currentProduct.id} is removed.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int = listOfProducts.size

    fun setProducts(products: List<Product>){
        listOfProducts = products
        notifyDataSetChanged()
    }

}