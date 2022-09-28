package com.example.ksero

import Beans.RProducts
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ksero.retailSeller_products.AdapterRProducts
    
class RetailSellerProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retail_seller_products)
        getAllProducts()
    }

    private fun getAllProducts() {
        val product1 = RProducts("Aceite", 66.00, "Primor", "Caja de 6 unidades")
        val product2 = RProducts("Sillao", 36.00, "Kiko", "Caja de 12 unidades")
        val product3 = RProducts("Leche", 84.00, "Gloria", "Caja de 24 unidades")

        val products = mutableListOf<RProducts>()

        products.add(product1)
        products.add(product2)
        products.add(product3)

        val recycler = findViewById<RecyclerView>(R.id.recyclerViewProducts)
        recycler.layoutManager = LinearLayoutManager(applicationContext)
        recycler.adapter = AdapterRProducts(products)
    }
}