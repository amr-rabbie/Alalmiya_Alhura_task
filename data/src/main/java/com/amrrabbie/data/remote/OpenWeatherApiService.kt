package com.amrrabbie.data.remote

import com.amrrabbie.domain.entity.openweather.OpenWeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApiService {

    @GET("forecast")
    suspend fun getOpenWeatherFromNetwork(
        @Query("q") q:String,
        @Query("appid") appid:String
    ):OpenWeatherResponse
}