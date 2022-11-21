package com.example.ksero.wholesaler_orders

import Beans.WOrders
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ksero.R

class WOrderViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val order = view.findViewById<TextView>(R.id.textViewItemNameValue)
    val quantity = view.findViewById<TextView>(R.id.textViewItemQuantityValue)
    val total = view.findViewById<TextView>(R.id.textViewItemTotalPriceValue)
    val price = view.findViewById<TextView>(R.id.textViewItemPriceValue)

    fun render(productModel: WOrders){
        quantity.text = productModel.quantity.toString()
        total.text = productModel.total.toString()
        price.text = productModel.price.toString()
        order.text = "Order #" + productModel.orderId.toString()
    }
}