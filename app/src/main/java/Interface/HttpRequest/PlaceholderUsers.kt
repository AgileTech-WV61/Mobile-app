package Interface.HttpRequest

import Models.HttpRequest.Users.SignInRequest
import Models.HttpRequest.Users.SignInResponse
import Models.HttpRequest.Users.User
import Models.HttpRequest.Users.UserGet
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface PlaceholderUsers {
    @GET("users/auth/get-all")
    fun getUsers(): Call<List<UserGet>>

    @POST("users/auth/sign-up")
    fun signUp(@Body user: User): Call<UserGet>

    @POST("users/auth/sign-in")
    fun signIn(@Body user: SignInRequest): Call<SignInResponse>

    @GET("users/auth/verify-token-retail-seller")
    fun verifyTokenRetailSeller(@Header("Authorization") authHeader: String): Call<Boolean>

    @GET("users/auth/verify-token-wholesaler")
    fun verifyTokenWholesaler(@Header("Authorization") authHeader: String): Call<Boolean>
}