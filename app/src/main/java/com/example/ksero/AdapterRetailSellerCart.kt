package com.example.ksero

import Beans.CartOrder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterRetailSellerCart(val cartOrderList: List<CartOrder>):RecyclerView.Adapter<CartOrderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartOrderViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CartOrderViewHolder(layoutInflater.inflate(R.layout.item_retail_seller_cart, parent, false))
    }

    override fun onBindViewHolder(holder: CartOrderViewHolder, position: Int) {
        val item = cartOrderList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return cartOrderList.size
    }

}