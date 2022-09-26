package com.example.ksero

import Beans.WProduct
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddProduct : AppCompatActivity() {

    lateinit var title : EditText
    lateinit var description : EditText
    lateinit var price : EditText
    lateinit var btn :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        title = findViewById(R.id.txtAddProductName)
        description = findViewById(R.id.txtAddProductDescription)
        price = findViewById(R.id.txtAddProductPrice)
        btn = findViewById(R.id.btnAddProduct)

        btn.setOnClickListener(View.OnClickListener {

            verifyProduct()

        })

    }

    private fun verifyProduct(){
        if (title.text.isNotEmpty() and description.text.isNotEmpty() and price.text.isNotEmpty()){

            val product = WProduct(
                title.text.toString(),description.text.toString(),price.text.toString().toDouble())

            saveProduct(product)
        }else{
            Toast.makeText(
                applicationContext,
                "Debe llenar todos los campos",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun saveProduct(product: WProduct){

        Toast.makeText(
            applicationContext,
            "Added successful product:${product.toString()}",
            Toast.LENGTH_LONG
        ).show()

        val intent = Intent(this, WholesalerProducts::class.java)
        startActivity(intent)

    }
}