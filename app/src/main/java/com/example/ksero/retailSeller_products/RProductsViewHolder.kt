package com.example.ksero.retailSeller_products

import Beans.RProducts
import Models.HttpRequest.Products.Product
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ksero.R

class RProductsViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val name = view.findViewById<TextView>(R.id.textViewItemNameValue)
    val description = view.findViewById<TextView>(R.id.textViewItemDescriptionValue)
    val price = view.findViewById<TextView>(R.id.textViewItemPriceValue)

    fun render(productModel: Product){
        name.text = productModel.name
        description.text = productModel.description
        price.text = productModel.price.toString()
    }
}