package com.amrrabbie.alalmiyaalhu

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.amrrabbie.alalmiyaalhuratask.databinding.WeatherRowBinding
import com.amrrabbie.domain.entity.openweather.ListItem



class OpenWeatherAdapter (val context: Context, val list:List<ListItem>) : RecyclerView.Adapter<OpenWeatherAdapter.OpenWeatherViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OpenWeatherAdapter.OpenWeatherViewHolder {
        return OpenWeatherViewHolder(WeatherRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: OpenWeatherAdapter.OpenWeatherViewHolder, position: Int) {
        var weather: ListItem =list.get(position)

        holder.binding.apply {

            weather?.let {
                txtdesc.text= weather.weather!![0]!!.description
                txttemp.text=weather.main?.temp.toString()
                txthumdity.text=weather.main?.humidity.toString()
                txtpressure.text=weather.main?.pressure.toString()
                txtwindspeed.text=weather.wind?.speed.toString()
                txtvisibility.text=weather.visibility.toString()

                val time =weather.dtTxt
                txttime.text=time!!.substring(time.indexOf(" ") + 1)

                txtdate.text=time!!.substring(0,time!!.indexOf(" "))

                imgicon.load( "http://openweathermap.org/img/w/" + weather.weather!![0]!!.icon + ".png"){
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