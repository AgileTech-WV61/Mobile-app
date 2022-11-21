package com.example.ksero.retailseller_orders

import Beans.ROrders
import Beans.WOrders
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ksero.R

class ROrderViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val quantity = view.findViewById<TextView>(R.id.textViewItemQuantityValue)
    val total = view.findViewById<TextView>(R.id.textViewItemTotalPriceValue)
    val price = view.findViewById<TextView>(R.id.textViewItemPriceValue)
    val orderId = view.findViewById<TextView>(R.id.textViewItemNameValue)

    fun render(productModel: ROrders){
        quantity.text = productModel.quantity.toString()
        total.text = productModel.total.toString()
        price.text = productModel.price.toString()
        orderId.text = "Order #" + productModel.orderId.toString();
    }
}