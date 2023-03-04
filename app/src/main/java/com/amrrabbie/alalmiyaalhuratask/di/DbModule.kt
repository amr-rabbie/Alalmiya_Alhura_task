package com.amrrabbie.alalmiyaalhuratask.di

import android.app.Application
import androidx.room.Room
import com.amrrabbie.data.db.WeatherDao
import com.amrrabbie.data.db.WeatherDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun provideWeatherDb(application: Application):WeatherDb=
        Room.databaseBuilder(application.applicationContext,
        WeatherDb::class.java,"weather_db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()


    @Provides
    @Singleton
    fun provideWeatherDao(weatherDb: WeatherDb):WeatherDao=
        weatherDb.weatherdao()


}