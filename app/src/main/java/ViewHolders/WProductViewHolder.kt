package ViewHolders

import Models.HttpRequest.Products.Product
import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ksero.EditProduct
import com.example.ksero.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class WProductViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {

    val context = view.context
    val name = view.findViewById<TextView>(R.id.txtTitleWholesalerProduct)
    val description = view.findViewById<TextView>(R.id.txtDescriptionWholesalerProduct)
    val price = view.findViewById<TextView>(R.id.txtPriceWholesalerProduct)
    lateinit var editBtn : FloatingActionButton

    fun render(productModel: Product){
        name.text = productModel.name
        description.text = productModel.description
        price.text = productModel.price.toString()
    }

    fun setOnClickListeners(){
        editBtn = this.itemView.findViewById(R.id.btnGoToEditProduct)
        editBtn.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val intent = Intent(context, EditProduct::class.java)
        context.startActivity(intent)
    }

}