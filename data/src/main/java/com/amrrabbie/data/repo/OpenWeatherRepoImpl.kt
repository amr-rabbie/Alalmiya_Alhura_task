package com.amrrabbie.data.repo

import androidx.lifecycle.LiveData
import com.amrrabbie.data.db.WeatherDao
import com.amrrabbie.data.remote.OpenWeatherApiService
import com.amrrabbie.domain.entity.openweather.OpenWeatherResponse
import com.amrrabbie.domain.entity.openweather.Weather
import com.amrrabbie.domain.repo.OpenWeatherRepo
import kotlinx.coroutines.flow.StateFlow

class OpenWeatherRepoImpl(private val openWeatherApiService: OpenWeatherApiService , private val weatherDao: WeatherDao) : OpenWeatherRepo {


    override suspend fun getOpenWeatherFromNetwork(q: String, appid: String): OpenWeatherResponse =
        openWeatherApiService.getOpenWeatherFromNetwork(q,appid)

    override fun insertWeather(weather: Weather) =
        weatherDao.insertWeather(weather)

    override fun deleteWeatherByCity(city: String) =
        weatherDao.deleteWeatherByCity(city)

    override fun getWeatherByCity(city: String): LiveData<List<Weather>>{
        return weatherDao.getWeatherByCity(city)
    }


}