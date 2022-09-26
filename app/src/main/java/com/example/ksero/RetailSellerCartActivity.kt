package com.example.ksero

import Beans.CartOrder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RetailSellerCartActivity : Fragment(R.layout.activity_retail_seller_cart) {

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_retail_seller_cart)

        // change top bar title
        supportActionBar?.title = "Cart"

        val cartOrderList = ArrayList<CartOrder>()
        // create a CartOrder
        cartOrderList.add(CartOrder("product1", 100.0, 1))
        cartOrderList.add(CartOrder("product2", 200.0, 2))
        cartOrderList.add(CartOrder("product3", 300.0, 3))
        cartOrderList.add(CartOrder("product4", 400.0, 4))
        cartOrderList.add(CartOrder("product5", 500.0, 5))


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCart)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = AdapterRetailSellerCart(cartOrderList)

        val payButton = findViewById<Button>(R.id.payButton)
        val totalPrice = cartOrderList.sumOf { it.productPrice * it.productQuantity }
        payButton.text = "PAY $${totalPrice}"

    }*/
}