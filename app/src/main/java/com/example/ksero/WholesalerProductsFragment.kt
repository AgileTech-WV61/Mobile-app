package com.example.ksero

import Adapters.AdapterWProduct
import Beans.WProduct
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class WholesalerProductsFragment : Fragment() {

    lateinit var btn : FloatingActionButton
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_wholesaler_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAllProducts(view)

        btn = view.findViewById(R.id.btnGoToAddProduct)

        btn.setOnClickListener {
            /*val intent = Intent(this, AddProduct::class.java)
            startActivity(intent)*/
        }
    }

    private fun getAllProducts(view: View){
        val product1 = WProduct("Yougurt","100 Unidades de un 1L",250.00)
        val product2 = WProduct("Coca Cola","100 Unidades de un 3L",700.00)
        val product3 = WProduct("Galletas Vainilla","100 Unidades",90.00)

        val products = mutableListOf<WProduct>()

        products.add(product1)
        products.add(product2)
        products.add(product3)
        products.add(product1)
        products.add(product2)
        products.add(product3)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerWProducts)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = AdapterWProduct(products)
    }
}