package ViewHolders

import Beans.WOrders
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ksero.R

class WOrderViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val order = view.findViewById<TextView>(R.id.textViewItemNameValue)
    val id = view.findViewById<TextView>(R.id.textViewItemIdValue)
    val quantity = view.findViewById<TextView>(R.id.textViewItemQuantityValue)
    val total = view.findViewById<TextView>(R.id.textViewItemTotalPriceValue)
    val price = view.findViewById<TextView>(R.id.textViewItemPriceValue)

    fun render(orderModel: WOrders){
        id.text = orderModel.id.toString()
        quantity.text = orderModel.quantity.toString()
        total.text = orderModel.total.toString()
        price.text = orderModel.price.toString()
    }
}