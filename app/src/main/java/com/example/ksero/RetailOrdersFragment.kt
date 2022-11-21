package com.example.ksero

import Beans.ROrders
import Beans.WOrders
import Interface.HttpRequest.PlaceholderOrders
import Interface.HttpRequest.PlaceholderProducts
import Models.HttpRequest.Orders.Orders
import Models.HttpRequest.Products.Product
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetailOrdersFragment : Fragment() {

    lateinit var ordersService: PlaceholderOrders
    lateinit var productsService: PlaceholderProducts
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_retail_orders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btnPending : Button = view.findViewById(R.id.btnPending)
        var btnAccepted : Button = view.findViewById(R.id.btnAccepted)

        sharedPreferences = requireActivity().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://ksero.herokuapp.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        ordersService = retrofit.create(PlaceholderOrders::class.java)
        productsService = retrofit.create(PlaceholderProducts::class.java)

        getAllAcceptedOrders(view)


        btnPending.setOnClickListener {
            btnPending.setTextColor(Color.parseColor("#FF3700B3"))
            btnAccepted.setTextColor(Color.BLACK)

            getAllPendingOrders(view)
        }

        btnAccepted.setOnClickListener {
            btnPending.setTextColor(Color.BLACK)
            btnAccepted.setTextColor(Color.parseColor("#FF3700B3"))

            getAllAcceptedOrders(view)
        }
    }

    private fun getAllPendingOrders(view: View) {
        val token = sharedPreferences.getString("token", null)
        val retailSellerId = sharedPreferences.getInt("id", 0)

        val call = ordersService.getWholesalerOrdersForRetailSeller("Bearer $token", retailSellerId)
        call.enqueue(object : retrofit2.Callback<List<Orders>> {
            override fun onResponse(
                call: retrofit2.Call<List<Orders>>,
                response: retrofit2.Response<List<Orders>>
            ) {

                if (response.isSuccessful) {
                    val ordersP = mutableListOf<ROrders>()
                    val orders = response.body()

                    if (orders != null) {
                        for (order in orders) {
                            val callProduct = productsService.getProduct("Bearer $token", order.productId)
                            callProduct.enqueue(object : retrofit2.Callback<Product> {
                                override fun onResponse(
                                    call: Call<Product>,
                                    response2: Response<Product>
                                ) {
                                    if (response2.isSuccessful) {
                                        val product = response2.body()
                                        if (product != null) {
                                            ordersP.add(ROrders(product.price, order.quantity, product.price.toDouble() * order.quantity, product.id))
                                            println(product.price)
                                        }
                                        val recycler = view.findViewById<RecyclerView>(R.id.recyclerViewCartAccepted)
                                        recycler.layoutManager = LinearLayoutManager(context)
                                        recycler.adapter = AdapterROrders(ordersP)
                                    }
                                }
                                override fun onFailure(call: Call<Product>, t: Throwable) {
                                    print(message = "error");
                                }
                            })
                            //ordersP.add(WOrders(20.0, order.quantity, 40.0))
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<Orders>>, t: Throwable) {
                print(message = "error");
            }
        })
    }

    private fun getAllAcceptedOrders(view: View) {
        val token = sharedPreferences.getString("token", null)
        val retailSellerId = sharedPreferences.getInt("id", 0)

        val call = ordersService.getRetailSellerOrdersForRetailSeller("Bearer $token", retailSellerId)
        call.enqueue(object : retrofit2.Callback<List<Orders>> {
            override fun onResponse(
                call: retrofit2.Call<List<Orders>>,
                response: retrofit2.Response<List<Orders>>
            ) {

                if (response.isSuccessful) {
                    val ordersP = mutableListOf<ROrders>()
                    val orders = response.body()

                    if (orders != null) {
                        for (order in orders) {
                            val callProduct = productsService.getProduct("Bearer $token", order.productId)
                            callProduct.enqueue(object : retrofit2.Callback<Product> {
                                override fun onResponse(
                                    call: Call<Product>,
                                    response2: Response<Product>
                                ) {
                                    if (response2.isSuccessful) {
                                        val product = response2.body()
                                        if (product != null) {
                                            ordersP.add(ROrders(product.price, order.quantity, product.price.toDouble() * order.quantity, order.id))
                                            println(product.price)
                                        }
                                        val recycler = view.findViewById<RecyclerView>(R.id.recyclerViewCartAccepted)
                                        recycler.layoutManager = LinearLayoutManager(context)
                                        recycler.adapter = AdapterROrders(ordersP)
                                    }
                                }
                                override fun onFailure(call: Call<Product>, t: Throwable) {
                                    print(message = "error");
                                }
                            })
                            //ordersP.add(WOrders(20.0, order.quantity, 40.0))
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<Orders>>, t: Throwable) {
                print(message = "error");
            }
        })
    }
}