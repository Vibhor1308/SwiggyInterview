package com.example.movieproject.model.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("&s=comedy&page=2")
    suspend fun getMovies(@Query("key") key:String): Response<List<Movie>>

    @GET("")
    suspend fun getMovieDetails(@Query("key") key : String) : Response<MovieDetails>
}