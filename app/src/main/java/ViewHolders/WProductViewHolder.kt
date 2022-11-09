package ViewHolders

import Models.HttpRequest.Products.Product
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.ksero.EditProduct
import com.example.ksero.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class WProductViewHolder(view: View, fragmentManager: FragmentManager): RecyclerView.ViewHolder(view), View.OnClickListener {

    val fragmentManager = fragmentManager
    val context = view.context
    lateinit var product: Product
    val name = view.findViewById<TextView>(R.id.txtTitleWholesalerProduct)
    val description = view.findViewById<TextView>(R.id.txtDescriptionWholesalerProduct)
    val price = view.findViewById<TextView>(R.id.txtPriceWholesalerProduct)
    lateinit var editBtn : FloatingActionButton

    fun render(productModel: Product){
        product = productModel
        name.text = productModel.name
        description.text = productModel.description
        price.text = productModel.price.toString()
    }

    fun setOnClickListeners(){
        editBtn = this.itemView.findViewById(R.id.btnGoToEditProduct)
        editBtn.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val fragment: Fragment = EditProduct(product)
        val fragmentManager: FragmentManager = this.fragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.containerView, fragment)
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit()
    }

}