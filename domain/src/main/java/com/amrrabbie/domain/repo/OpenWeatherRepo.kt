package com.amrrabbie.domain.repo

import com.amrrabbie.domain.entity.openweather.OpenWeatherResponse

interface OpenWeatherRepo {

    suspend fun getOpenWeatherFromNetwork(q:String,appid:String):OpenWeatherResponse
}