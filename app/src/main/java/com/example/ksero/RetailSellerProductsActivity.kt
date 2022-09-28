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

    }
}