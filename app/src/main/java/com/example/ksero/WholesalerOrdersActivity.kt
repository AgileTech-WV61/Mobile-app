package com.example.ksero

import Beans.WOrders
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WholesalerOrdersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wholesaler_orders)
        getAllOrders()
    }

    private fun getAllOrders(){
        val order1 = WOrders(35.00, 6, 210.00)
        val order2 = WOrders(40.00, 7, 280.00)
        val order3 = WOrders(25.00, 10, 250.00)

        val orders = mutableListOf<WOrders>()

        orders.add(order1)
        orders.add(order2)
        orders.add(order3)
        orders.add(order1)
        orders.add(order2)
        orders.add(order3)

        val recycler = findViewById<RecyclerView>(R.id.recyclerViewCartAccepted)
        recycler.layoutManager = LinearLayoutManager(applicationContext)
        recycler.adapter = AdapterWOrders(orders)

        //Order Pending

        val orderP1 = WOrders(35.00, 6, 210.00)
        val orderP2 = WOrders(40.00, 7, 280.00)
        val orderP3 = WOrders(25.00, 10, 250.00)

        val ordersP = mutableListOf<WOrders>()

        ordersP.add(orderP1)
        ordersP.add(orderP2)
        ordersP.add(orderP3)

        val recyclerP = findViewById<RecyclerView>(R.id.recyclerViewCartPending)
        recycler.layoutManager = LinearLayoutManager(applicationContext)
        recycler.adapter = AdapterWOrdersPending(orders)

    }
}