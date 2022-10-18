package com.example.ksero

import Adapters.AdapterWProduct
import Interface.HttpRequest.PlaceholderProducts
import Models.HttpRequest.Products.Product
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ksero.retailSeller_products.AdapterRProducts
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WholesalerProductsFragment : Fragment() {

    lateinit var btn : FloatingActionButton
    lateinit var productsService: PlaceholderProducts
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_wholesaler_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireActivity().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://ksero.herokuapp.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        productsService = retrofit.create(PlaceholderProducts::class.java)

        getAllProductsByWhosalerId(view)

        btn = view.findViewById(R.id.btnGoToAddProduct)

        btn.setOnClickListener {
            val intent = Intent(context, AddProduct::class.java)
            startActivity(intent)
        }
    }

    private fun getAllProductsByWhosalerId(view: View){
        val token = sharedPreferences.getString("token", null)
        val call = productsService.getProductsByWhosalerId("Bearer $token",2)
        call.enqueue(object : retrofit2.Callback<List<Product>> {
            override fun onResponse(
                call: retrofit2.Call<List<Product>>,
                response: retrofit2.Response<List<Product>>
            ) {
                if (response.isSuccessful) {
                    val products = response.body()
                    println(products)
                    val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerWProducts)
                    recyclerView.layoutManager = LinearLayoutManager(context)
                    recyclerView.adapter = AdapterWProduct(products!!)
                }
            }

            override fun onFailure(call: retrofit2.Call<List<Product>>, t: Throwable) {
                println(t.message)
            }
        })
    }
}