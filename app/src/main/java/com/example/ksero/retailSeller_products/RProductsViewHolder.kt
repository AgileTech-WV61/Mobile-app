package com.example.ksero.retailSeller_products

import Beans.RProducts
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ksero.R

class RProductsViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val name = view.findViewById<TextView>(R.id.textViewItemNameValue)
    val description = view.findViewById<TextView>(R.id.textViewItemDescriptionValue)
    val brant = view.findViewById<TextView>(R.id.textViewItemBrantValue)
    val price = view.findViewById<TextView>(R.id.textViewItemPriceValue)

    fun render(productModel: RProducts){
        name.text = productModel.name
        description.text = productModel.description
        brant.text = productModel.brant
        price.text = productModel.price.toString()
    }
}