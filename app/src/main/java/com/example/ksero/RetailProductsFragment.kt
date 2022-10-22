package com.example.ksero

import Beans.RProducts
import Interface.HttpRequest.PlaceholderProducts
import Interface.HttpRequest.PlaceholderUsers
import Models.HttpRequest.Products.Product
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ksero.retailSeller_products.AdapterRProducts
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetailProductsFragment : Fragment() {

    lateinit var productsService: PlaceholderProducts
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_retail_seller_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = requireActivity().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://ksero.herokuapp.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        productsService = retrofit.create(PlaceholderProducts::class.java)
        getAllProducts(view)

    }

    private fun getAllProducts(view: View) {
        val token = sharedPreferences.getString("token", null)
        val call = productsService.getProducts("Bearer $token")
        call.enqueue(object : retrofit2.Callback<List<Product>> {
            override fun onResponse(
                call: retrofit2.Call<List<Product>>,
                response: retrofit2.Response<List<Product>>
            ) {
                if (response.isSuccessful) {
                    val products = response.body()
                    println(products)
                    val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewProducts)
                    recyclerView.layoutManager = LinearLayoutManager(context)
                    recyclerView.adapter = AdapterRProducts(products!!)
                }
            }

            override fun onFailure(call: retrofit2.Call<List<Product>>, t: Throwable) {
                println(t.message)
            }
        })
    }
}