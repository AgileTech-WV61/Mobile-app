package com.example.ksero

import Interface.HttpRequest.PlaceholderProducts
import Models.HttpRequest.Products.Product
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Profile : Fragment() {
    lateinit var productsService: PlaceholderProducts
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = requireActivity().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)

        val t = sharedPreferences.getString("token", "")!!
        println("retrieved t: $t")

        val retrofit = Retrofit.Builder()
            .baseUrl("https://ksero.herokuapp.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        productsService = retrofit.create(PlaceholderProducts::class.java)

        val call = productsService.getProducts("Bearer $t")
        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    val products = response.body()
                    for (product in products!!) {
                        println(product.name)
                    }
                }
            }
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                println("error: $t")
            }
        })

    }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val t = sharedPreferences.getString("token", "")!!
        println("retrieved t: $t")

        val retrofit = Retrofit.Builder()
            .baseUrl("https://ksero.herokuapp.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        productsService = retrofit.create(PlaceholderProducts::class.java)

        val call = productsService.getProducts("Bearer $t")
        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    val products = response.body()
                    for (product in products!!) {
                        println(product.name)
                    }
                }
            }
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                println("error: $t")
            }
        })


    }*/
}

/*
class Profile : AppCompatActivity() {
    lateinit var productsService: PlaceholderProducts
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val t = sharedPreferences.getString("token", "")!!
        println("retrieved t: $t")

        val retrofit = Retrofit.Builder()
            .baseUrl("https://ksero.herokuapp.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        productsService = retrofit.create(PlaceholderProducts::class.java)

        val call = productsService.getProducts("Bearer $t")
        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    val products = response.body()
                    for (product in products!!) {
                        println(product.name)
                    }
                }
            }
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                println("error: $t")
            }
        })


    }
}
*/