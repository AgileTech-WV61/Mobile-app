package ViewHolders

import Beans.WOrders
import Interface.HttpRequest.PlaceholderOrders
import Interface.HttpRequest.PlaceholderProducts
import Models.HttpRequest.Orders.Orders
import Models.HttpRequest.Products.Product
import android.content.Context
import android.content.SharedPreferences
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.ksero.EditProduct
import com.example.ksero.R
import com.example.ksero.WholesalerOrdersFragment
import com.example.ksero.WholesalerProductsFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WOrderPendingViewHolder (view: View, fragmentManager: FragmentManager): RecyclerView.ViewHolder(view), View.OnClickListener {
    val context = view.context
    val fragmentManager = fragmentManager
    lateinit var order: WOrders

    val id = view.findViewById<TextView>(R.id.textViewItemIdValuePending)
    val quantity = view.findViewById<TextView>(R.id.textViewItemQuantityValuePending)
    val total = view.findViewById<TextView>(R.id.textViewItemTotalPriceValuePending)
    val price = view.findViewById<TextView>(R.id.textViewItemPriceValuePending)

    lateinit var denyBtn : Button
    lateinit var acceptBtn: Button
    lateinit var sharedPreferences: SharedPreferences
    lateinit var ordersService: PlaceholderOrders

    fun initial(orderModel: WOrders){

        order = orderModel;

        denyBtn = this.itemView.findViewById(R.id.btnDenyPending)
        acceptBtn = this.itemView.findViewById(R.id.btnAcceptPending)

        sharedPreferences = context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://ksero.herokuapp.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        ordersService = retrofit.create(PlaceholderOrders::class.java)
    }

    fun render(orderModel: WOrders){
        id.text = orderModel.id.toString()
        quantity.text = orderModel.quantity.toString()
        total.text = orderModel.total.toString()
        price.text = orderModel.price.toString()
    }

    fun setOnClickListeners(){
        denyBtn.setOnClickListener(this)
        acceptBtn.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        when(view!!.id){
            R.id.btnDenyPending->{
                delete(order.id)
            }
            R.id.btnAcceptPending->{
                createRetailSellerOrder()
                delete(order.id)
            }
        }
    }

    fun createRetailSellerOrder(){
        val token = sharedPreferences.getString("token", null)

        val orderDto =Orders(order.id,order.quantity,order.retailSellerId,order.productId)

        val call = ordersService.createProducts("Bearer $token",orderDto)
        call.enqueue(object : retrofit2.Callback<Orders> {
            override fun onResponse(
                call: retrofit2.Call<Orders>,
                response: retrofit2.Response<Orders>
            ) {
                if (response.isSuccessful) {
                    val orders = response.body()
                    Toast.makeText(
                        context,
                        "successful",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: retrofit2.Call<Orders>, t: Throwable) {
                println(t.message)
            }
        })



        val fragment: Fragment = WholesalerOrdersFragment()
        val fragmentManager: FragmentManager = this.fragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.containerView, fragment)
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit()
    }

    fun delete(id: Int){

        val token = sharedPreferences.getString("token", null)

        val call = ordersService.deleteProduct("Bearer $token",id)
        call.enqueue(object : retrofit2.Callback<Void> {
            override fun onResponse(
                call: retrofit2.Call<Void>,
                response: retrofit2.Response<Void>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(
                        context,
                        "successful",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: retrofit2.Call<Void>, t: Throwable) {
                println(t.message)
            }
        })
        val fragment: Fragment = WholesalerOrdersFragment()
        val fragmentManager: FragmentManager = this.fragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.containerView, fragment)
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit()
    }
}