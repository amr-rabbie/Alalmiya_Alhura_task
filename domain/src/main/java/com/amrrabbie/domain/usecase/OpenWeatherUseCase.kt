package com.amrrabbie.domain.usecase

import com.amrrabbie.domain.repo.OpenWeatherRepo

class OpenWeatherUseCase(private val openWeatherRepo: OpenWeatherRepo) {

    suspend fun getOpenWeatherFromNetwork(q:String,appid:String)=
        openWeatherRepo.getOpenWeatherFromNetwork(q,appid)
}