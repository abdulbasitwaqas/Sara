package com.jsbl.sara.viewModel

import android.app.Application
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jsbl.sara.Encrpition.Constaint
import com.jsbl.sara.Encrpition.Cryptography_Android
import com.jsbl.sara.Models.requests.LoginRequest
import com.jsbl.sara.Models.response.LoginResponse
import com.jsbl.sara.utils.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


class LoginViewModel(application: Application) : BaseViewModel(application) {

    private lateinit var mobileNumber: String
    private lateinit var password: String


    var isForgetPass = false

    init {

    }





      fun loginUser(phone:String, mpin:String, fcm:String) {
        logD(APP_TAG, "method Called")
        localService.loginUser(phone, mpin, fcm).enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                setError(call, "Internet Connectivity issue")
            }

            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                if (response.code() == 200) {
                    try {
                        val response: LoginResponse? = response.body()

                    } catch (e: Exception) {
                        setError(response, null)
                    }
                } else {
                    setError(response)
                }
            }

        })
    }



}