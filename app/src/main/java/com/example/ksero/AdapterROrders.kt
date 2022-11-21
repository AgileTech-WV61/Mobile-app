package com.example.ksero

import Beans.ROrders
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ksero.retailseller_orders.ROrderViewHolder

class AdapterROrders ( val orderList: List<ROrders>): RecyclerView.Adapter<ROrderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ROrderViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ROrderViewHolder(layoutInflater.inflate(R.layout.item_retailseller_orders,parent,false))
    }

    override fun onBindViewHolder(holder: ROrderViewHolder, position: Int) {
        var item = orderList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = orderList.size
}