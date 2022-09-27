package com.example.ksero

import Beans.WOrders
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterWOrdersPending (val orderList: List<WOrders>): RecyclerView.Adapter<WOrderPendingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WOrderPendingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return WOrderPendingViewHolder(layoutInflater.inflate(R.layout.item_wholesaler_orders,parent,false))
    }

    override fun onBindViewHolder(holder: WOrderPendingViewHolder, position: Int) {
        var item = orderList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = orderList.size
}