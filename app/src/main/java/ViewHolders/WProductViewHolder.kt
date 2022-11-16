package ViewHolders

import Interface.HttpRequest.PlaceholderProducts
import Models.HttpRequest.Products.Product
import android.content.Context
import android.content.SharedPreferences
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.ksero.EditProduct
import com.example.ksero.R
import com.example.ksero.WholesalerProductsFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WProductViewHolder(view: View, fragmentManager: FragmentManager): RecyclerView.ViewHolder(view), View.OnClickListener {

    val fragmentManager = fragmentManager
    val context = view.context

    lateinit var product: Product
    val name = view.findViewById<TextView>(R.id.txtTitleWholesalerProduct)
    val description = view.findViewById<TextView>(R.id.txtDescriptionWholesalerProduct)
    val price = view.findViewById<TextView>(R.id.txtPriceWholesalerProduct)

    lateinit var editBtn : FloatingActionButton
    lateinit var deleteBtn: FloatingActionButton
    lateinit var sharedPreferences: SharedPreferences
    lateinit var productsService: PlaceholderProducts

    fun initial(productModel: Product){

        product = productModel

        sharedPreferences = context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://ksero.herokuapp.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        productsService = retrofit.create(PlaceholderProducts::class.java)
    }

    fun render(productModel: Product){

        name.text = productModel.name
        description.text = productModel.description
        price.text = productModel.price.toString()
    }

    fun setOnClickListeners(){
        editBtn = this.itemView.findViewById(R.id.btnGoToEditProduct)
        deleteBtn = this.itemView.findViewById(R.id.btnDeletedProduct)
        editBtn.setOnClickListener(this)
        deleteBtn.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        when(view!!.id){
            R.id.btnGoToEditProduct->{
                val fragment: Fragment = EditProduct(product)
                val fragmentManager: FragmentManager = this.fragmentManager
                val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.containerView, fragment)
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit()
            }
            R.id.btnDeletedProduct->{
                delete(product.id)
            }
        }
    }

    fun delete(id: Int){
        val token = sharedPreferences.getString("token", null)

        val call = productsService.deleteProduct("Bearer $token",id)
        call.enqueue(object : retrofit2.Callback<Void> {
            override fun onResponse(
                call: retrofit2.Call<Void>,
                response: retrofit2.Response<Void>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(
                        context,
                        "Deleted successful product",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: retrofit2.Call<Void>, t: Throwable) {
                println(t.message)
            }
        })

        val fragment: Fragment = WholesalerProductsFragment()
        val fragmentManager: FragmentManager = this.fragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.containerView, fragment)
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit()
    }

}