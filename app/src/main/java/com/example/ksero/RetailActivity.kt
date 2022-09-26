package com.example.ksero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class RetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retail)

        var bottomNavigationView : BottomNavigationView = findViewById(R.id.bottomNavigationView);
        var cartFragment = RetailSellerCartActivity();
        var productsFragment = RetailProductsFragment();
        var ordersFragment = RetailOrdersFragment();
        var settingsFragment = RetailSettingsFragment();

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_products -> {
                    setCurrentFragment(productsFragment)
                }
                R.id.nav_orders -> {
                    setCurrentFragment(ordersFragment)
                }
                R.id.nav_cart -> {
                    setCurrentFragment(cartFragment)
                }
                R.id.nav_settings -> {
                    setCurrentFragment(settingsFragment)
                }
            }
            true
        }
    }

    private fun setCurrentFragment(fragment : Fragment)
    {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.containerView, fragment)
            commit()
        }
    }
}