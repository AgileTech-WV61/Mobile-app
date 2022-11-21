package Adapters

import Models.HttpRequest.Products.Product
import ViewHolders.WProductViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ksero.R

class AdapterWProduct( val productList: List<Product>, val fragmentManager: FragmentManager): RecyclerView.Adapter<WProductViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return WProductViewHolder(layoutInflater.inflate(R.layout.item_wholesaler_product,parent,false),fragmentManager)
    }

    override fun onBindViewHolder(holder: WProductViewHolder, position: Int) {
        var item = productList[position]
        holder.initial(item)
        holder.render(item)
        holder.setOnClickListeners()
    }

    override fun getItemCount(): Int = productList.size
}