package Adapters

import Beans.WOrders
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ViewHolders.WOrderViewHolder
import com.example.ksero.R

class AdapterWOrders ( val orderList: List<WOrders>): RecyclerView.Adapter<WOrderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WOrderViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return WOrderViewHolder(layoutInflater.inflate(R.layout.item_wholesaler_orders,parent,false))
    }

    override fun onBindViewHolder(holder: WOrderViewHolder, position: Int) {
        var item = orderList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = orderList.size
}