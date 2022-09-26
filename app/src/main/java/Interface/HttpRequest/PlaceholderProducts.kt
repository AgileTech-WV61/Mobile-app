package Interface.HttpRequest

import Models.HttpRequest.Products.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface PlaceholderProducts {
    @GET("products")
    fun getProducts(@Header("Authorization") authHeader: String): Call<List<Product>>
}