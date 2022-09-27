package com.example.ksero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToHome: Button = findViewById(R.id.toHomeButton)
        btnToHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }


        val btnToRegister: Button = findViewById(R.id.toRegisterButton)
        btnToRegister.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val btnToCart: Button = findViewById(R.id.btnRegister)
        btnToCart.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        val btnToWholesalerProducts: Button = findViewById(R.id.toWholesalerProducts)
        btnToWholesalerProducts.setOnClickListener {
            val intent = Intent(this, WholesalerProducts::class.java)
            startActivity(intent)
        }

        val btnToRetailSellerProducts: Button = findViewById(R.id.toRetailSellerProducts)
        btnToRetailSellerProducts.setOnClickListener {
            val intent = Intent(this, RetailSellerProductsActivity::class.java)
            startActivity(intent)
        }

        val btnToWholesalerOrders: Button = findViewById(R.id.toWholesalerOrders)
        btnToWholesalerOrders.setOnClickListener {
            val intent = Intent(this, WholesalerOrdersActivity::class.java)
            startActivity(intent)
        }
    }
}