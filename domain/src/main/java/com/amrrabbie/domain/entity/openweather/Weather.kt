package com.amrrabbie.domain.entity.openweather

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "weather_table")
@Parcelize
class Weather(var city:String,var desc:String,var icon:String,
var temp:String,var humditity:String,var pressure:String,
var wind_speed :String,var visibility:String,var datetime:String) : Parcelable {

    @PrimaryKey(autoGenerate = true)
    var id:Int=0

    @ColumnInfo(name = "image", typeAffinity = ColumnInfo.BLOB)
    @Ignore
    var img:String=""
}