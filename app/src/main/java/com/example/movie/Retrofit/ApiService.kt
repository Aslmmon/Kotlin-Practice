package com.example.movie.Retrofit

import com.example.movie.dataList
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/MohamedWael/1406437f14e9a769a3a572a78906388f/raw/5be50e67c96c5ed1da9fe6344d2dd7befef0ba25")
    fun getAllMovies() : Call<dataList>
}