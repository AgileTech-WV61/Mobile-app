package com.example.ksero

import Beans.CartOrder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.newSingleThreadContext

class RetailSellerCartActivity : Fragment() {

    private lateinit var adapter: AdapterRetailSellerCart
    private lateinit var recyclerView: RecyclerView
    private lateinit var cartOrderList: ArrayList<CartOrder>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return  inflater.inflate(R.layout.activity_retail_seller_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // create a CartOrder
        cartOrderList = arrayListOf<CartOrder>()
        cartOrderList.add(CartOrder("product1", 100.0, 1))
        cartOrderList.add(CartOrder("product2", 200.0, 2))
        cartOrderList.add(CartOrder("product3", 300.0, 3))
        cartOrderList.add(CartOrder("product4", 400.0, 4))
        cartOrderList.add(CartOrder("product5", 500.0, 5))

        val layoutManager = LinearLayoutManager(requireActivity().applicationContext)
        recyclerView = view.findViewById(R.id.recyclerViewCart)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = AdapterRetailSellerCart(cartOrderList)
        recyclerView.adapter = adapter

        val payButton = view.findViewById<Button>(R.id.payButton)
        val totalPrice = cartOrderList.sumOf { it.productPrice * it.productQuantity }
        payButton.text = "PAY $${totalPrice}"
    }
}