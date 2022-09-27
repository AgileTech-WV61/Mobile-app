package com.example.ksero

import Interface.HttpRequest.PlaceholderUsers
import Models.HttpRequest.Users.SignInRequest
import Models.HttpRequest.Users.SignInResponse
import Models.HttpRequest.Users.User
import Models.HttpRequest.Users.UserGet
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegisterActivity : AppCompatActivity() {

    lateinit var usersService: PlaceholderUsers
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_view)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://ksero.herokuapp.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        usersService = retrofit.create(PlaceholderUsers::class.java)

        val registerButton = findViewById<TextView>(R.id.registerButton)
        registerButton.setOnClickListener {
            register()
        }
        val call = usersService.getUsers()
        call.enqueue(object : Callback<List<UserGet>> {
            override fun onResponse(call: Call<List<UserGet>>, response: Response<List<UserGet>>) {
                if (response.isSuccessful) {
                    val users = response.body()
                    for (user in users!!) {
                        println(user.email)
                    }
                }
            }

            override fun onFailure(call: Call<List<UserGet>>, t: Throwable) {
                println(t.message)
            }
        })
    }

    private fun register(){
        val username = findViewById<TextView>(R.id.username)
        val password = findViewById<TextView>(R.id.password)
        println("username: ${username.text}")
        println("password: ${password.text}")
        val call = usersService.signUp(
            User(username.text.toString(),
            "${username.text}@test",
            password.text.toString(), arrayOf("ROLE_RETAIL_SELLER"))
        )

            call.enqueue(object : Callback<UserGet> {
            override fun onResponse(call: Call<UserGet>, response: Response<UserGet>) {
                if (response.isSuccessful) {
                    login(username.text.toString(), password.text.toString())
                }
            }

            override fun onFailure(call: Call<UserGet>, t: Throwable) {
                println(t.message)
            }
        })
    }

    private fun login(username: String, password: String){
        val call = usersService.signIn(
            SignInRequest(username,
                password)
        )

        call.enqueue(object : Callback<SignInResponse> {
            override fun onResponse(call: Call<SignInResponse>, response: Response<SignInResponse>) {
                if (response.isSuccessful) {

                    val token = response.body()?.token
                    // save token in shared preferences
                    val editor = sharedPreferences.edit()
                    editor.apply {
                        putString("token", token)
                    }.apply()

                    // get token from shared preferences
                    val t = sharedPreferences.getString("token", null)
                    println("t: $t")


                    val intent = Intent(this@RegisterActivity, Profile::class.java)
                    startActivity(intent)
                }
            }

            override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                println(t.message)
            }
        })
    }
}