package com.example.ksero

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class WholesalerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wholesaler)

        val userName = intent.getStringExtra("userName");

        var bottomNavigationView : BottomNavigationView = findViewById(R.id.bottomNavigationView);
        var productsFragment = WholesalerProductsFragment();
        var ordersFragment = WholesalerOrdersFragment();
        var settingsFragment = WholesalerSettingsFragment();

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_products -> {
                    val data = Bundle()
                    data.putString("userName", userName)
                    productsFragment.arguments = data
                    setCurrentFragment(productsFragment)
                }
                R.id.nav_orders -> {
                    setCurrentFragment(ordersFragment)
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