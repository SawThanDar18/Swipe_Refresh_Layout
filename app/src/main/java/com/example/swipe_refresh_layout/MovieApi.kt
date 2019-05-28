package com.example.swipe_refresh_layout

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.simplifiedcoding.in/course-api/"

public interface MovieApi {

    @GET("movies")
    fun getMovies() : Call<List<Movie>>

    companion object{
        operator fun invoke() : MovieApi{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovieApi::class.java)
        }
    }



}