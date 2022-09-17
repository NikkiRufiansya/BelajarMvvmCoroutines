package com.example.belejarmvvmcoroutines.repository

import com.example.belejarmvvmcoroutines.retrofit.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    suspend fun getAllMovies() = retrofitService.getAllMovies()

}