package com.example.ksero

import Beans.CartOrder
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartOrderViewHolder(view: View):RecyclerView.ViewHolder(view) {
    val productName = view.findViewById<TextView>(R.id.textViewItemNameValue)
    val productPrice = view.findViewById<TextView>(R.id.textViewItemPriceValue)
    val productQuantity = view.findViewById<TextView>(R.id.textViewItemQuantityValue)
    val productTotalPrice = view.findViewById<TextView>(R.id.textViewItemTotalPriceValue)

    fun render(cartOrder: CartOrder){
        productName.text = cartOrder.productName
        productPrice.text = cartOrder.productPrice.toString()
        productQuantity.text = cartOrder.productQuantity.toString()
        productTotalPrice.text = cartOrder.productPrice.times(cartOrder.productQuantity).toString()
    }
}