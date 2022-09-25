package Adapters

import Beans.WProduct
import ViewHolders.WProductViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ksero.R

class AdapterWProduct( val productList: List<WProduct>): RecyclerView.Adapter<WProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return WProductViewHolder(layoutInflater.inflate(R.layout.item_wholesaler_product,parent,false))
    }

    override fun onBindViewHolder(holder: WProductViewHolder, position: Int) {
        var item = productList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = productList.size
}