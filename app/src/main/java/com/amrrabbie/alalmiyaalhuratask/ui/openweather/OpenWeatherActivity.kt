package com.amrrabbie.alalmiyaalhuratask.ui.openweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androiddeveloper.amrrabbie.kotlinapidb.utils.Network
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.amrrabbie.alalmiyaalhu.OpenWeatherAdapter
import com.amrrabbie.alalmiyaalhuratask.databinding.ActivityOpenWeatherBinding
import com.amrrabbie.domain.entity.openweather.ListItem
import com.amrrabbie.domain.entity.openweather.OpenWeatherResponse
import com.amrrabbie.domain.entity.openweather.Weather
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OpenWeatherActivity : AppCompatActivity() {

    lateinit var binding: ActivityOpenWeatherBinding
    lateinit var openWeatherAdapter: OpenWeatherAdapter
    lateinit var openWeatherAdapterOffline: OpenWeatherAdapterOffline
    val openWeatherViewModel:OpenWeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityOpenWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnsearch.setOnClickListener {
            if(binding.edtcity.text.toString().isEmpty())
                Toast.makeText(this,"must enter city",Toast.LENGTH_LONG).show()
                else
            bindOpenWeatherData()
        }

    }

    private fun bindOpenWeatherData() {
        if (Network.isNetworkAvailable(this))
            loadDataFromNetwork()
        else
            loadDataFromDb()
    }

    private fun loadDataFromNetwork() {

            startLoading()

            lifecycleScope.launchWhenCreated {
                openWeatherViewModel.getOpenWeatherFromNetwork(
                    binding.edtcity.text.toString(),
                    "3a46b8f5a2e3d2fcd6c5083afc261630"
                )

                openWeatherViewModel.weather.collect {
                    it?.let {

                        deleteWeatherByCity(it)

                        openWeatherAdapter =
                            OpenWeatherAdapter(this@OpenWeatherActivity, it.list as List<ListItem>)

                        binding.weatherRv.apply {
                            adapter = openWeatherAdapter
                            hasFixedSize()
                            layoutManager = LinearLayoutManager(
                                this@OpenWeatherActivity,
                                LinearLayoutManager.HORIZONTAL,
                                false
                            )
                        }
                        hideLoading()
                    }
                }
            }

    }

    private fun loadDataFromDb() {
        startLoading()
        openWeatherViewModel.getWeatherByCity(binding.edtcity.text.toString())

        openWeatherViewModel.weatherList.observe(this, Observer { response ->
            if(! response.isNullOrEmpty()){
                openWeatherAdapterOffline= OpenWeatherAdapterOffline(this,response)
                binding.weatherRv.apply {
                    adapter=openWeatherAdapterOffline
                    hasFixedSize()
                    layoutManager=LinearLayoutManager(this@OpenWeatherActivity,LinearLayoutManager.HORIZONTAL,false)
                }
                hideLoading()
            }else{
                Toast.makeText(this,"error hapened , try again",Toast.LENGTH_LONG).show()
                hideLoading()
            }
        })
    }

    private fun deleteWeatherByCity(openWeatherResponse: OpenWeatherResponse) {
        openWeatherViewModel.deleteWeatherByCity(binding.edtcity.text.toString())
        insertWeatherInDb(openWeatherResponse.list)
    }

    private fun insertWeatherInDb(list: List<ListItem?>?) {
        list?.let{
            for(weather in list){
                var mweather=Weather(binding.edtcity.text.toString(),weather?.weather!![0]?.description!! ,weather?.weather!![0]?.icon!!,
                    weather.main?.temp.toString(),weather.main?.humidity.toString(),weather.main?.pressure.toString(),
                    weather.wind?.speed.toString(),weather.visibility.toString(),weather.dtTxt!!)

                openWeatherViewModel.insertWeather(mweather)
            }

        }
    }

    private fun hideLoading() {
        binding.apply {
            pbar.visibility=View.GONE
            weatherRv.visibility=View.VISIBLE
        }
    }

    private fun startLoading() {
        binding.apply {
            pbar.visibility=View.VISIBLE
            weatherRv.visibility=View.GONE
        }
    }
}