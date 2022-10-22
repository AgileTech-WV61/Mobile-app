package com.example.ksero

import Beans.CartOrder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RetailSellerProductsActivity : AppCompatActivity() {

    private lateinit var adapter: AdapterRetailSellerCart
    private lateinit var recyclerView: RecyclerView
    private lateinit var item: ArrayList<CartOrder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retail_seller_products)

        val btnAdd:Button = findViewById(R.id.btnAddToCart)

        //Añadir al Carrito de Compras
        btnAdd.setOnClickListener(){
            val productName:TextView = findViewById(R.id.textViewItemNameValue)
            val productPrice:TextView = findViewById(R.id.textViewItemTotalPriceValue)
            val productQuantity:TextView = findViewById(R.id.textViewItemQuantityValue)

            item.add(CartOrder(productName.text.toString(),
                productPrice.text.toString().toDouble(),
                productQuantity.text.toString().toInt()))

            val layoutManager = LinearLayoutManager(this)
            recyclerView = findViewById(R.id.recyclerViewCart)
            recyclerView.layoutManager = layoutManager
            recyclerView.setHasFixedSize(true)
            adapter = AdapterRetailSellerCart(item)
            recyclerView.adapter = adapter
        }

        getAllProducts()
    }

    private fun getAllProducts() {

    }
}