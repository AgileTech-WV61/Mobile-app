package com.example.ksero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToRegister: Button = findViewById(R.id.toRegisterButton)
        btnToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        val btnToCart: Button = findViewById(R.id.toCartButton)
        btnToCart.setOnClickListener {
            val intent = Intent(this, RetailSellerCartActivity::class.java)
            startActivity(intent)
        }

        val btnToLogin: Button = findViewById(R.id.toLoginButton)
        btnToLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val btnToProfile: Button = findViewById(R.id.toProfileButton)
        btnToProfile.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

        val btnToWholesalerOrders: Button = findViewById(R.id.toWholesalerOrdersButton)
        btnToWholesalerOrders.setOnClickListener {
            val intent = Intent(this, WholesalerOrdersActivity::class.java)
            startActivity(intent)
        }
    }
}