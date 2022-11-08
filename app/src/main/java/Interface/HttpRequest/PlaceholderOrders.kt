package Interface.HttpRequest

import Models.HttpRequest.Orders.Orders
import Models.HttpRequest.Products.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface PlaceholderOrders {
    @GET("wholesaler-orders")
    fun getWholesalerOrders(@Header("Authorization") authHeader: String): Call<List<Orders>>
}