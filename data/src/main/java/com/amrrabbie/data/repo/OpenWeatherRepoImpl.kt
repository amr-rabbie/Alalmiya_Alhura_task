package com.amrrabbie.data.repo

import com.amrrabbie.data.remote.OpenWeatherApiService
import com.amrrabbie.domain.entity.openweather.OpenWeatherResponse
import com.amrrabbie.domain.repo.OpenWeatherRepo

class OpenWeatherRepoImpl(private val openWeatherApiService: OpenWeatherApiService) : OpenWeatherRepo {


    override suspend fun getOpenWeatherFromNetwork(q: String, appid: String): OpenWeatherResponse =
        openWeatherApiService.getOpenWeatherFromNetwork(q,appid)


}