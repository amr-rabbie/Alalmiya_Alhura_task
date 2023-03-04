package com.amrrabbie.alalmiyaalhuratask.ui.openweather

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.amrrabbie.alalmiyaalhu.OpenWeatherAdapter
import com.amrrabbie.alalmiyaalhuratask.databinding.WeatherRowBinding
import com.amrrabbie.domain.entity.openweather.ListItem
import com.amrrabbie.domain.entity.openweather.Weather

class OpenWeatherAdapterOffline (val context: Context, val list:List<Weather>) : RecyclerView.Adapter<OpenWeatherAdapterOffline.OpenWeatherViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OpenWeatherAdapterOffline.OpenWeatherViewHolder {
        return OpenWeatherViewHolder(WeatherRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: OpenWeatherAdapterOffline.OpenWeatherViewHolder, position: Int) {
        var weather: Weather =list.get(position)

        holder.binding.apply {

            weather?.let {
                txtdesc.text= weather.desc
                txttemp.text=weather.temp
                txthumdity.text=weather.humditity
                txtpressure.text=weather.pressure
                txtwindspeed.text=weather.wind_speed
                txtvisibility.text=weather.visibility

                val time =weather.datetime
                txttime.text=time!!.substring(time.indexOf(" ") + 1)

                txtdate.text=time!!.substring(0,time!!.indexOf(" "))

                imgicon.load( "http://openweathermap.org/img/w/" + weather.icon + ".png"){
                    crossfade(1000)
                    crossfade(true)
                }
            }



        }

        holder.itemView.setOnClickListener {mview->

        }
    }

    override fun getItemCount()=
        list.size

    inner class OpenWeatherViewHolder(val binding: WeatherRowBinding):
        RecyclerView.ViewHolder(binding.root)
}