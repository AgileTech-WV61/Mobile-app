package com.example.ksero

import android.content.Intent
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

class EditProduct : Fragment() {

    lateinit var title : EditText
    lateinit var description : EditText
    lateinit var price : EditText
    lateinit var btn : Button

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

        btn.setOnClickListener(View.OnClickListener {

        })

    }

    /*private fun getProductById(): WProduct {
        val product1 = WProduct("Yougurt","100 Unidades de un 1L",250.00)

        return product1
    }

    private fun verifyProduct(){
        if (title.text.isNotEmpty() and description.text.isNotEmpty() and price.text.isNotEmpty()){

            val product = WProduct(
                title.text.toString(),description.text.toString(),price.text.toString().toDouble())

            editProduct(product)
        }else{
            Toast.makeText(
                applicationContext,
                "All Items Must be completed",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun editProduct(product: WProduct){
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
class EditProduct : AppCompatActivity() {

    lateinit var title : EditText
    lateinit var description : EditText
    lateinit var price : EditText
    lateinit var btn : Button
    lateinit var btnBack : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_product)

        title = findViewById(R.id.txtEditProductName)
        description = findViewById(R.id.txtEditProductDescription)
        price = findViewById(R.id.txtEditProductPrice)
        btn = findViewById(R.id.btnEditProduct)

        /*val product = getProductById()

        title.setText(product.title)
        description.setText(product.description)
        price.setText(product.price.toString())*/

        btn.setOnClickListener(View.OnClickListener {
            //verifyProduct()
        })

        btnBack.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    /*private fun getProductById(): WProduct {
        val product1 = WProduct("Yougurt","100 Unidades de un 1L",250.00)

        return product1
    }

    private fun verifyProduct(){
        if (title.text.isNotEmpty() and description.text.isNotEmpty() and price.text.isNotEmpty()){

            val product = WProduct(
                title.text.toString(),description.text.toString(),price.text.toString().toDouble())

            editProduct(product)
        }else{
            Toast.makeText(
                applicationContext,
                "All Items Must be completed",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun editProduct(product: WProduct){
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