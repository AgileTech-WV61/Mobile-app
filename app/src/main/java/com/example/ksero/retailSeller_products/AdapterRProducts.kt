package com.example.ksero.retailSeller_products

import Beans.RProducts
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ksero.R

class AdapterRProducts(private val productList: List<RProducts >): RecyclerView.Adapter<RProductsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RProductsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RProductsViewHolder(layoutInflater.inflate(R.layout.item_retail_seller_products,parent,false))
    }

    override fun onBindViewHolder(holder: RProductsViewHolder, position: Int) {
        var item = productList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = productList.size
}