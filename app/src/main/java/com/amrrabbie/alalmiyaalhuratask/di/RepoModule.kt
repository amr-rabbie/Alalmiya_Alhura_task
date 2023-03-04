package com.amrrabbie.alalmiyaalhuratask.di

import com.amrrabbie.data.remote.OpenWeatherApiService
import com.amrrabbie.data.repo.OpenWeatherRepoImpl
import com.amrrabbie.domain.repo.OpenWeatherRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideOpenWeatherRepo(openWeatherApiService: OpenWeatherApiService):OpenWeatherRepo=
        OpenWeatherRepoImpl(openWeatherApiService)
}