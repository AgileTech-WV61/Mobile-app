package com.example.ksero.retailSeller_products

import Models.HttpRequest.Products.Product
import android.R.array
import android.content.SharedPreferences
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ksero.R


class RProductsViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {

    lateinit var id: Number
    val name = view.findViewById<TextView>(R.id.textViewItemNameValue)
    val description = view.findViewById<TextView>(R.id.textViewItemDescriptionValue)
    val price = view.findViewById<TextView>(R.id.textViewItemPriceValue)
    lateinit var addBtn : Button

    fun render(productModel: Product){
        id = productModel.id
        name.text = productModel.name
        description.text = productModel.description
        price.text = productModel.price.toString()
    }

    fun setOnClickListeners(){
        addBtn = this.itemView.findViewById(R.id.btnAddToCar)
        addBtn.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        // console
        // get context

        val sharedPreferences = view?.context?.getSharedPreferences("sharedPrefs", 0)
        val editor = sharedPreferences?.edit()
        var exists: Boolean = sharedPreferences?.contains(id.toString()) ?: false
        for(i in 0..(sharedPreferences?.getInt("shopping_cart" + "_size", 0) ?: 0)){
            if(sharedPreferences?.getInt("shopping_cart_id_$i", 0) == id){
                exists = true
            }
        }
        if(!exists){
            editor?.putInt("shopping_cart" + "_size",
                sharedPreferences.getInt("shopping_cart" + "_size", 0) + 1)
            editor?.putInt("shopping_cart_id_" + sharedPreferences.getInt("shopping_cart" + "_size", 0),
                id.toInt())
            editor?.putString("shopping_cart_name_" + sharedPreferences.getInt("shopping_cart" + "_size", 0),
                name.text.toString())
            editor?.putFloat("shopping_cart_price_" + sharedPreferences.getInt("shopping_cart" + "_size", 0),
                price.text.toString().toFloat())
            editor?.putInt("shopping_cart_quantity_" + sharedPreferences.getInt("shopping_cart" + "_size", 0),
                1)
            editor?.apply()
        }
        println(id)
    }
}