package com.amrrabbie.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.amrrabbie.domain.entity.openweather.Weather
import kotlinx.coroutines.flow.StateFlow

@Dao
interface WeatherDao {

    @Insert(entity = Weather::class)
    fun insertWeather(weather: Weather)

    @Query("delete from weather_table where city=:city")
    fun deleteWeatherByCity(city:String)

    @Query("select * from weather_table where city=:city")
    fun getWeatherByCity(city:String): LiveData<List<Weather>>
}