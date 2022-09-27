package com.example.ksero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_view)

        val btnToRegister: Button = findViewById(R.id.loginButton)
        btnToRegister.setOnClickListener {
            var userType = "retail";
            if (userType.toString().lowercase() == "wholesaler")
            {
                val intent = Intent(this, WholesalerActivity::class.java)
                startActivity(intent)
            } else if (userType.toString().lowercase() == "retail") {
                val intent = Intent(this, RetailActivity::class.java)
                startActivity(intent)
            }
        }
    }
}