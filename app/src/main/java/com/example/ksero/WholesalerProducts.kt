package com.example.ksero

import Adapters.AdapterWProduct
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class WholesalerProducts : AppCompatActivity() {

    lateinit var btn : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wholesaler_products)
        getAllProducts()

        btn = findViewById(R.id.btnGoToAddProduct)

        btn.setOnClickListener {
            val intent = Intent(this, AddProduct::class.java)
            startActivity(intent)
        }

    }

    private fun getAllProducts(){
       /* val product1 = WProduct("Yougurt","100 Unidades de un 1L",250.00)
        val product2 = WProduct("Coca Cola","100 Unidades de un 3L",700.00)
        val product3 = WProduct("Galletas Vainilla","100 Unidades",90.00)

        val products = mutableListOf<WProduct>()

        products.add(product1)
        products.add(product2)
        products.add(product3)
        products.add(product1)
        products.add(product2)
        products.add(product3)

        val recycler = findViewById<RecyclerView>(R.id.recyclerWProducts)
        recycler.layoutManager = LinearLayoutManager(applicationContext)
        recycler.adapter = AdapterWProduct(products)
        */
    }
}