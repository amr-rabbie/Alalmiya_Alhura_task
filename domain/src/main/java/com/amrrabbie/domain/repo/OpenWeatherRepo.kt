package com.amrrabbie.domain.repo

import androidx.lifecycle.LiveData
import com.amrrabbie.domain.entity.openweather.OpenWeatherResponse
import com.amrrabbie.domain.entity.openweather.Weather
import kotlinx.coroutines.flow.StateFlow

interface OpenWeatherRepo {

    suspend fun getOpenWeatherFromNetwork(q:String,appid:String):OpenWeatherResponse

    fun insertWeather(weather: Weather)

    fun deleteWeatherByCity(city:String)

    fun getWeatherByCity(city:String): LiveData<List<Weather>>
}