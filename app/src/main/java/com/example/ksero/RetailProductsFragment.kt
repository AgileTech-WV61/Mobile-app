package com.example.ksero

import Beans.RProducts
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ksero.retailSeller_products.AdapterRProducts
import com.google.android.material.bottomnavigation.BottomNavigationView

class RetailProductsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_retail_seller_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAllProducts(view)

    }

    private fun getAllProducts(view: View) {
        val product1 = RProducts("Aceite", 66.00, "Primor", "Caja de 6 unidades")
        val product2 = RProducts("Sillao", 36.00, "Kiko", "Caja de 12 unidades")
        val product3 = RProducts("Leche", 84.00, "Gloria", "Caja de 24 unidades")

        val products = mutableListOf<RProducts>()

        products.add(product1)
        products.add(product2)
        products.add(product3)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerViewProducts)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = AdapterRProducts(products)
    }
}