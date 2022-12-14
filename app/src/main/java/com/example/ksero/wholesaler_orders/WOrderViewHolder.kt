package com.example.ksero.wholesaler_orders

import Beans.WOrders
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ksero.R

class WOrderViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val quantity = view.findViewById<TextView>(R.id.textViewItemQuantityValue)
    val total = view.findViewById<TextView>(R.id.textViewItemTotalPriceValue)
    val price = view.findViewById<TextView>(R.id.textViewItemPriceValue)

    fun render(productModel: WOrders){
        quantity.text = productModel.quantity.toString()
        total.text = productModel.total.toString()
        price.text = productModel.price.toString()
    }

}