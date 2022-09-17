package com.example.belejarmvvmcoroutines.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    fun getInstance() : Retrofit{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://howtodoandroid.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
}