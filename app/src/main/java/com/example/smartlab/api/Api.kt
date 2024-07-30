package com.example.smartlab.api

import retrofit2.http.Header
import retrofit2.http.POST

interface Api {
    companion object {
        val BASE_URL_SMARTLAB = "https://iis.ngknn.ru/NGKNN/МамшеваЮС/MedicMadlab/"
    }

    @POST("api/SendCode")
    suspend fun sendCodeEmail(@Header("User-email") email: String):String

    @POST("api/SignIn")
    suspend fun signInCode(@Header("User-code") code: String , @Header("User-email") email: String): String
}