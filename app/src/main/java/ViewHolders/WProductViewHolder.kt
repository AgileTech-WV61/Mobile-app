package ViewHolders

import Beans.WProduct
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ksero.R

class WProductViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val name = view.findViewById<TextView>(R.id.txtTitleWholesalerProduct)
    val description = view.findViewById<TextView>(R.id.txtDescriptionWholesalerProduct)
    val price = view.findViewById<TextView>(R.id.txtPriceWholesalerProduct)

    fun render(productModel: WProduct){
        name.text = productModel.title
        description.text = productModel.description
        price.text = productModel.price.toString()
    }

}