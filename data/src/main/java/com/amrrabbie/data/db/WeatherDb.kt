package com.amrrabbie.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amrrabbie.domain.entity.openweather.Weather

@Database(entities = [Weather::class], version = 1)
abstract class WeatherDb : RoomDatabase() {

    abstract fun weatherdao():WeatherDao

}