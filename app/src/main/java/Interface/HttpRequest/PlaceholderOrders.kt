package Interface.HttpRequest

import Models.HttpRequest.Orders.Orders
import Models.HttpRequest.Products.Product
import retrofit2.Call
import retrofit2.http.*

interface PlaceholderOrders {
    @GET("wholesaler-orders")
    fun getWholesalerOrders(@Header("Authorization") authHeader: String): Call<List<Orders>>

    @GET("retail-seller-orders")
    fun getRetailSellerOrders(@Header("Authorization") authHeader: String): Call<List<Orders>>

    @POST("retail-seller-orders")
    fun createProducts(@Header("Authorization") authHeader: String, @Body orders: Orders): Call<Orders>

    @DELETE("wholesaler-orders/{id}")
    fun deleteProduct(@Header("Authorization") authHeader: String, @Path("id") id: Int): Call<Void>
}