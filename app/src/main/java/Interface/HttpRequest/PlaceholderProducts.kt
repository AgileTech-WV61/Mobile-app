package Interface.HttpRequest

import Models.HttpRequest.Products.Product
import retrofit2.Call
import retrofit2.http.*

interface PlaceholderProducts {
    @GET("products")
    fun getProducts(@Header("Authorization") authHeader: String): Call<List<Product>>

    @GET("products/{id}")
    fun getProduct(@Header("Authorization") authHeader: String, @Path("id") id: Int): Call<Product>

    @DELETE("products/{id}")
    fun deleteProduct(@Header("Authorization") authHeader: String, @Path("id") id: Int): Call<Void>

    @GET("products/wholesalerId/{wholesalerId}")
    fun getProductsByWhosalerId(@Header("Authorization") authHeader: String, @Path("wholesalerId")wholesalerId: Int): Call<List<Product>>

    @POST("products")
    fun createProducts(@Header("Authorization") authHeader: String, @Body product: Product): Call<Product>

    @PUT("products/{id}")
    fun updateProducts(@Header("Authorization") authHeader: String,@Path("id") id:Int, @Body product: Product): Call<Product>
}