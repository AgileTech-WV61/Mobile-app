package Adapters

import Beans.WOrders
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ViewHolders.WOrderPendingViewHolder
import androidx.fragment.app.FragmentManager
import com.example.ksero.R

class AdapterWOrdersPending (val orderList: List<WOrders>,  val fragmentManager: FragmentManager): RecyclerView.Adapter<WOrderPendingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WOrderPendingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return WOrderPendingViewHolder(layoutInflater.inflate(R.layout.item_wholesaler_orders_pending,parent,false),fragmentManager)
    }

    override fun onBindViewHolder(holder: WOrderPendingViewHolder, position: Int) {
        var item = orderList[position]
        holder.initial(item)
        holder.render(item)
        holder.setOnClickListeners()
    }

    override fun getItemCount(): Int = orderList.size
}