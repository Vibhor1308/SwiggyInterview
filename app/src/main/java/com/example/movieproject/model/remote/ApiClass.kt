package com.example.movieproject.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClass {
    val api1 = Retrofit.Builder()
        .baseUrl("http://www.omdbapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(API::class.java)

    val api2 = Retrofit.Builder()
        .baseUrl("http://www.omdbapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(API::class.java)
}