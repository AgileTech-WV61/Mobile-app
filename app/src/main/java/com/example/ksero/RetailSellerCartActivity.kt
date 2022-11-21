package com.example.ksero

import Beans.CartOrder
import Interface.HttpRequest.PlaceholderOrders
import Interface.HttpRequest.PlaceholderProducts
import Models.HttpRequest.Orders.OrderPost
import Models.HttpRequest.Orders.Orders
import Models.HttpRequest.Products.Product
import Models.HttpRequest.Users.SignInResponse
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.newSingleThreadContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetailSellerCartActivity : Fragment() {
    lateinit var productsService: PlaceholderProducts
    lateinit var ordersService : PlaceholderOrders
    private lateinit var adapter: AdapterRetailSellerCart
    private lateinit var recyclerView: RecyclerView
    private lateinit var cartOrderList: ArrayList<CartOrder>
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return  inflater.inflate(R.layout.activity_retail_seller_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://ksero.herokuapp.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        productsService = retrofit.create(PlaceholderProducts::class.java)
        ordersService = retrofit.create(PlaceholderOrders::class.java)


        // create a CartOrder
        cartOrderList = arrayListOf<CartOrder>()
        sharedPreferences = requireActivity().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        println(sharedPreferences.getString("token", null))
        for(i in 0..(sharedPreferences.getInt("shopping_cart" + "_size", 0))){

            if(sharedPreferences.getInt("shopping_cart_id_$i", 0) != 0){

                cartOrderList.add(CartOrder(
                    sharedPreferences.getString("shopping_cart_name_$i", "").toString(),
                    sharedPreferences.getFloat("shopping_cart_price_$i", 0f).toDouble(),
                    sharedPreferences.getInt("shopping_cart_quantity_$i", 0)
                ))
            }
        }


        val layoutManager = LinearLayoutManager(requireActivity().applicationContext)
        recyclerView = view.findViewById(R.id.recyclerViewCart)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = AdapterRetailSellerCart(cartOrderList)
        recyclerView.adapter = adapter

        val payButton = view.findViewById<Button>(R.id.payButton)
        payButton.setOnClickListener {
            for(i in 0..(sharedPreferences.getInt("shopping_cart" + "_size", 0))){

                if(sharedPreferences.getInt("shopping_cart_id_$i", 0) != 0){
                    println("quantity: "+sharedPreferences.getInt("shopping_cart_quantity_$i", 0))
                    println("retailId: "+sharedPreferences.getInt("id", 0))
                    println("productId: "+sharedPreferences.getInt("shopping_cart_id_$i", 0))

                    val callCreateWholesaler = ordersService.createWholesalerOrders(
                        "Bearer " + sharedPreferences.getString("token", null),
                        OrderPost(
                            sharedPreferences.getInt("shopping_cart_quantity_$i", 0),
                            sharedPreferences.getInt("id", 0),
                            sharedPreferences.getInt("shopping_cart_id_$i", 0)
                            )
                        )

                    callCreateWholesaler.enqueue(object: Callback<Orders>{
                        override fun onResponse(call: Call<Orders>, response: Response<Orders>) {
                            println(response.body()?.id)
                            if (response.isSuccessful) {
                                println(response);

                            }
                        }

                        override fun onFailure(call: Call<Orders>, t: Throwable) {
                            println(t.message)
                        }
                    })
                }
            }
        }
        val totalPrice = cartOrderList.sumOf { it.productPrice * it.productQuantity }
        payButton.text = "PAY $${totalPrice}"
    }


}