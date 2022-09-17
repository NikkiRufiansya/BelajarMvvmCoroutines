package com.example.belejarmvvmcoroutines.retrofit

import com.example.belejarmvvmcoroutines.models.Movie
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET("movielist.json")
    suspend fun getAllMovies() : Response<List<Movie>>

    companion object {
        fun create() : RetrofitService{
            return RetrofitClient.getInstance().create(RetrofitService::class.java)
        }

    }
}