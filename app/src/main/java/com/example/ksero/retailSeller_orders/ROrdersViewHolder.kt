package com.example.ksero.retailSeller_orders

import Beans.ROrders
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ksero.R

class ROrdersViewHolder (view: View): RecyclerView.ViewHolder(view) {

    val quantity = view.findViewById<TextView>(R.id.textViewItemQuantityValue)
    val total = view.findViewById<TextView>(R.id.textViewItemTotalPriceValue)
    val price = view.findViewById<TextView>(R.id.textViewItemPriceValue)

    fun render(productModel: ROrders){
        quantity.text = productModel.quantity.toString()
        total.text = productModel.total.toString()
        price.text = productModel.price.toString()
    }

}