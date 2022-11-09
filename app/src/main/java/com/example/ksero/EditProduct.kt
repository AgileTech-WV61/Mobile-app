package com.example.ksero

import Interface.HttpRequest.PlaceholderProducts
import Models.HttpRequest.Products.Product
import Models.HttpRequest.Users.User
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory

class EditProduct(product: Product) : Fragment() {

    //val productId = id
    val editProduct= product
    lateinit var title : EditText
    lateinit var description : EditText
    lateinit var price : EditText
    lateinit var btn : Button
    lateinit var sharedPreferences: SharedPreferences
    lateinit var productsService: PlaceholderProducts

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_edit_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title = view.findViewById(R.id.txtEditProductName)
        description = view.findViewById(R.id.txtEditProductDescription)
        price = view.findViewById(R.id.txtEditProductPrice)
        btn = view.findViewById(R.id.btnEditProduct)

        sharedPreferences = requireActivity().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://ksero.herokuapp.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        productsService = retrofit.create(PlaceholderProducts::class.java)

        title.setText(editProduct.name)
        description.setText(editProduct.description)
        price.setText(editProduct.price.toString())

        btn.setOnClickListener(View.OnClickListener {
            verifyProduct()
        })
    }

    private fun verifyProduct(){
        if (title.text.isNotEmpty() and description.text.isNotEmpty() and price.text.isNotEmpty()){


            val product = Product(
                editProduct.id,title.text.toString(),description.text.toString(),editProduct.wholesaler,
                price.text.toString().toDouble())

            editProduct(product)
        }else{
            Toast.makeText(
                context,
                "All Items Must be completed",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun editProduct(product: Product){
        val token = sharedPreferences.getString("token", null)

        val call = productsService.updateProducts("Bearer $token",product.id,product)
        call.enqueue(object : retrofit2.Callback<Product> {
            override fun onResponse(
                call: retrofit2.Call<Product>,
                response: retrofit2.Response<Product>
            ) {
                if (response.isSuccessful) {
                    val product = response.body()
                    Toast.makeText(
                        context,
                        "Added successful product:${product?.description}",
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