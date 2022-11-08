package Interface.HttpRequest

import Models.HttpRequest.Products.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface PlaceholderProducts {
    @GET("products")
    fun getProducts(@Header("Authorization") authHeader: String): Call<List<Product>>

    @GET("products/{productId}")
    fun getProductById(@Header("Authorization") authHeader: String, @Path("productId")productId: Int): Call<Product>

    @GET("products/wholesalerId/{wholesalerId}")
    fun getProductsByWhosalerId(@Header("Authorization") authHeader: String, @Path("wholesalerId")wholesalerId: Int): Call<List<Product>>
}