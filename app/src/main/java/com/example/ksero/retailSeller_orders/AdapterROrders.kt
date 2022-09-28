package com.example.ksero.retailSeller_orders

import Beans.ROrders
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ksero.R

class AdapterROrders (val orderList: List<ROrders>): RecyclerView.Adapter<ROrdersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ROrdersViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ROrdersViewHolder(layoutInflater.inflate(R.layout.item_wholesaler_orders,parent,false))
    }

    override fun onBindViewHolder(holder: ROrdersViewHolder, position: Int) {
        var item = orderList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = orderList.size
}