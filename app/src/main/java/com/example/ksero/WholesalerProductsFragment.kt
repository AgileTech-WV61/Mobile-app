package com.example.ksero

import Adapters.AdapterWProduct
import Interface.HttpRequest.PlaceholderProducts
import Models.HttpRequest.Products.Product
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class WholesalerProductsFragment : Fragment() {

    lateinit var btn : FloatingActionButton
    lateinit var productsService: PlaceholderProducts
    lateinit var sharedPreferences: SharedPreferences
    lateinit var btnProfile: ImageButton
    lateinit var btnSetting: ImageButton
    lateinit var txtGreet: TextView
    val fragment: Fragment = AddProduct()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_wholesaler_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txtGreet = view.findViewById(R.id.txtGreet)

        var data = this.arguments
        if (data != null) {
            val userName = data.getString("userName")
            txtGreet.setText("Hi, " + userName + "!")
        }

        sharedPreferences = requireActivity().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://ksero.herokuapp.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        productsService = retrofit.create(PlaceholderProducts::class.java)

        getAllProductsByWhosalerId(view)

        btn = view.findViewById(R.id.btnGoToAddProduct)
        btnProfile = view.findViewById(R.id.btnProfile)
        btnSetting = view.findViewById(R.id.btnSetting)

        btn.setOnClickListener {
            val fragment: Fragment = AddProduct()
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.containerView, fragment)
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit()
        }

        btnSetting.setOnClickListener(View.OnClickListener {
            val fragment: Fragment = WholesalerSettingsFragment()
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.containerView, fragment)
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit()
        })

        btnProfile.setOnClickListener(View.OnClickListener {

            val fragment: Fragment = Profile()
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.containerView, fragment)
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit()

            //val intent = Intent(context, Profile::class.java)
            //startActivity(intent)
        })
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
                    recyclerView.adapter = AdapterWProduct(products!!, requireActivity().supportFragmentManager)
                }
            }

            override fun onFailure(call: retrofit2.Call<List<Product>>, t: Throwable) {
                println(t.message)
            }
        })
    }
}