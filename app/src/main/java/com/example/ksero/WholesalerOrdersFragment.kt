package com.example.ksero

import Beans.WOrders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WholesalerOrdersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_wholesaler_orders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAllOrders(view)
    }

    private fun getAllOrders(view: View){
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

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerViewCartAccepted)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = AdapterWOrders(orders)

        //Order Pending

        val orderP1 = WOrders(35.00, 6, 210.00)
        val orderP2 = WOrders(40.00, 7, 280.00)
        val orderP3 = WOrders(25.00, 10, 250.00)

        val ordersP = mutableListOf<WOrders>()

        ordersP.add(orderP1)
        ordersP.add(orderP2)
        ordersP.add(orderP3)

        val recyclerP = view.findViewById<RecyclerView>(R.id.recyclerViewCartPending)
        recyclerP.layoutManager = LinearLayoutManager(context)
        recyclerP.adapter = AdapterWOrdersPending(orders)

    }
}