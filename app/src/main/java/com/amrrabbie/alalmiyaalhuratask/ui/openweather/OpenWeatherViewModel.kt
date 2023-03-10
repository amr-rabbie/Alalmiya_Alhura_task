package com.amrrabbie.alalmiyaalhuratask.ui.openweather

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amrrabbie.domain.entity.openweather.OpenWeatherResponse
import com.amrrabbie.domain.entity.openweather.Weather
import com.amrrabbie.domain.entity.openweather.WeatherItem
import com.amrrabbie.domain.usecase.OpenWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OpenWeatherViewModel
@Inject
constructor(private val openWeatherUseCase: OpenWeatherUseCase) : ViewModel(){

    private var _weather= MutableStateFlow<OpenWeatherResponse?>(null)
    val weather:MutableStateFlow<OpenWeatherResponse?> get() = _weather

    lateinit var weatherList:LiveData<List<Weather>>



    fun getOpenWeatherFromNetwork(q:String,appid:String){
        viewModelScope.launch {
            try{
                _weather.value=openWeatherUseCase.getOpenWeatherFromNetwork(q,appid)
            }catch (ex:Exception){
                Log.e("TAG", "getOpenWeatherFromNetwork: ${ex.message}", )
            }
        }
    }

    fun insertWeather(weather: Weather)=
        openWeatherUseCase.insertWeather(weather)

    fun deleteWeatherByCity(city:String)=
        openWeatherUseCase.deleteWeatherByCity(city)

    fun getWeatherByCity(city:String){
        weatherList=openWeatherUseCase.getWeatherByCity(city)
    }


}