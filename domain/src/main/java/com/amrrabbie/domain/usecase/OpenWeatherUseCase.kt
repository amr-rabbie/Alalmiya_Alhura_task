package com.amrrabbie.domain.usecase

import com.amrrabbie.domain.entity.openweather.Weather
import com.amrrabbie.domain.repo.OpenWeatherRepo

class OpenWeatherUseCase(private val openWeatherRepo: OpenWeatherRepo) {

    suspend fun getOpenWeatherFromNetwork(q:String,appid:String)=
        openWeatherRepo.getOpenWeatherFromNetwork(q,appid)

    fun insertWeather(weather: Weather)=
        openWeatherRepo.insertWeather(weather)

    fun deleteWeatherByCity(city:String)=
        openWeatherRepo.deleteWeatherByCity(city)

    fun getWeatherByCity(city:String)=
        openWeatherRepo.getWeatherByCity(city)
    
}