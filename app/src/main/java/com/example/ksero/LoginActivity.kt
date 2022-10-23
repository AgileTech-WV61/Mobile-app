package com.example.ksero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import Interface.HttpRequest.PlaceholderUsers
import Models.HttpRequest.Users.SignInRequest
import Models.HttpRequest.Users.SignInResponse
import android.content.Context
import android.content.SharedPreferences
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {

    lateinit var usersService: PlaceholderUsers
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_view)

        /*val btnToRegister: Button = findViewById(R.id.loginButton)
        btnToRegister.setOnClickListener {
            var userType = "retail";
            if (userType.toString().lowercase() == "wholesaler")
            {
                val intent = Intent(this, WholesalerActivity::class.java)
                startActivity(intent)
            } else if (userType.toString().lowercase() == "retail") {
                val intent = Intent(this, RetailActivity::class.java)
                startActivity(intent)
            }
        }*/
        sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://ksero.herokuapp.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        usersService = retrofit.create(PlaceholderUsers::class.java)

        val loginContinueButton = findViewById<Button>(R.id.loginContinueButton)
        loginContinueButton.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val username: String = findViewById<TextView>(R.id.loginUsername).text.toString()
        val password: String = findViewById<TextView>(R.id.loginPassword).text.toString()
        val call = usersService.signIn(
            SignInRequest(
                username,
                password
            )
        )
        call.enqueue(object : Callback<SignInResponse> {
            override fun onResponse(
                call: Call<SignInResponse>,
                response: Response<SignInResponse>
            ) {
                if (response.isSuccessful) {
                    val token = response.body()?.token
                    // save token in shared preferences
                    val editor = sharedPreferences.edit()
                    editor.apply {
                        putString("token", token)
                    }.apply()

                    // verify token
                    val callVerifyTokenRetailSeller = usersService.verifyTokenRetailSeller("Bearer $token")
                    callVerifyTokenRetailSeller.enqueue(object : Callback<Boolean> {
                        override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                            if (response.isSuccessful) {
                                // go to retail seller view
                                val intent = Intent(this@LoginActivity, RetailActivity::class.java)
                                startActivity(intent)
                            }
                        }

                        override fun onFailure(call: Call<Boolean>, t: Throwable) {

                        }
                    })
                    val callVerifyTokenWholesaler = usersService.verifyTokenWholesaler("Bearer $token")
                    callVerifyTokenWholesaler.enqueue(object : Callback<Boolean> {
                        override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                            if (response.isSuccessful) {
                                // go to wholesaler view
                                val intent = Intent(this@LoginActivity, WholesalerActivity::class.java)
                                intent.putExtra("userName", username);
                                startActivity(intent)
                            }
                        }

                        override fun onFailure(call: Call<Boolean>, t: Throwable) {

                        }
                    })

                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@LoginActivity, "Bad Credentials", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                Toast.makeText(this@LoginActivity, "Error", Toast.LENGTH_SHORT).show()
            }
        })
    }


}