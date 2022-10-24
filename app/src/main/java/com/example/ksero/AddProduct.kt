package com.example.ksero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class AddProduct : Fragment() {

    lateinit var title : EditText
    lateinit var description : EditText
    lateinit var price : EditText
    lateinit var btn :Button

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

        btn.setOnClickListener(View.OnClickListener {
            // TODO: Here will be the logic
        })
    }

   /* private fun verifyProduct(){
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

    }*/
}

/*
class AddProduct : AppCompatActivity() {

    lateinit var title : EditText
    lateinit var description : EditText
    lateinit var price : EditText
    lateinit var btn :Button
    lateinit var btnBack: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        title = findViewById(R.id.txtAddProductName)
        description = findViewById(R.id.txtAddProductDescription)
        price = findViewById(R.id.txtAddProductPrice)
        btn = findViewById(R.id.btnAddProduct)
        btnBack = findViewById(R.id.btnBack)

        btn.setOnClickListener(View.OnClickListener {
            // TODO: Here will be the logic
        })

        btnBack.setOnClickListener(View.OnClickListener{
            finish()
        })

    }

   /* private fun verifyProduct(){
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

    }*/
}
*/