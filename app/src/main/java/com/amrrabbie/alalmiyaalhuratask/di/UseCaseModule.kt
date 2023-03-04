package com.amrrabbie.alalmiyaalhuratask.di

import com.amrrabbie.domain.repo.OpenWeatherRepo
import com.amrrabbie.domain.usecase.OpenWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideOpenWeatherUseCase(openWeatherRepo: OpenWeatherRepo):OpenWeatherUseCase=
        OpenWeatherUseCase(openWeatherRepo)
}