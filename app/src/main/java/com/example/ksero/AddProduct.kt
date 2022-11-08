package com.example.ksero

import Adapters.AdapterWProduct
import Interface.HttpRequest.PlaceholderProducts
import Models.HttpRequest.Products.Product
import Models.HttpRequest.Users.User
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AddProduct : Fragment() {

    lateinit var title : EditText
    lateinit var description : EditText
    lateinit var price : EditText
    lateinit var btn :Button
    lateinit var sharedPreferences: SharedPreferences
    lateinit var productsService: PlaceholderProducts


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_add_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title = view.findViewById(R.id.txtAddProductName)
        description = view.findViewById(R.id.txtAddProductDescription)
        price = view.findViewById(R.id.txtAddProductPrice)
        btn = view.findViewById(R.id.btnAddProduct)

        sharedPreferences = requireActivity().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://ksero.herokuapp.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        productsService = retrofit.create(PlaceholderProducts::class.java)

        btn.setOnClickListener(View.OnClickListener {
            verifyProduct()
        })
    }

    private fun verifyProduct(){
        if (title.text.isNotEmpty() and description.text.isNotEmpty() and price.text.isNotEmpty()){

            val wholesalerId = sharedPreferences.getInt("id", 0)
            val user = User(wholesalerId)
            val product = Product(
                title.text.toString(),description.text.toString(),user,price.text.toString().toDouble())

            saveProduct(product)
        }else{
            Toast.makeText(
                context,
                "Debe llenar todos los campos",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun saveProduct(product: Product){

        val token = sharedPreferences.getString("token", null)

        val call = productsService.createProducts("Bearer $token",product)
        call.enqueue(object : retrofit2.Callback<Product> {
            override fun onResponse(
                call: retrofit2.Call<Product>,
                response: retrofit2.Response<Product>
            ) {
                if (response.isSuccessful) {
                    val product = response.body()
                    Toast.makeText(
                        context,
                        "Added successful product:${product?.name}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: retrofit2.Call<Product>, t: Throwable) {
                println(t.message)
            }
        })



        val fragment: Fragment = WholesalerProductsFragment()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.containerView, fragment)
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit()

    }
}