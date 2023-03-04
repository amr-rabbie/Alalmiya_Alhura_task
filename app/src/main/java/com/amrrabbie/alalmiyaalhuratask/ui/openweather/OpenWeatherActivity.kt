package com.amrrabbie.alalmiyaalhuratask.ui.openweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.amrrabbie.alalmiyaalhu.OpenWeatherAdapter
import com.amrrabbie.alalmiyaalhuratask.R
import com.amrrabbie.alalmiyaalhuratask.databinding.ActivityOpenWeatherBinding
import com.amrrabbie.domain.entity.openweather.ListItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OpenWeatherActivity : AppCompatActivity() {

    lateinit var binding: ActivityOpenWeatherBinding
    lateinit var openWeatherAdapter: OpenWeatherAdapter
    val openWeatherViewModel:OpenWeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityOpenWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnsearch.setOnClickListener {
            bindOpenWeatherData()
        }


    }

    private fun bindOpenWeatherData() {
        try{
            loadDataFromNetwork()
        }catch (ex:Exception){

        }
    }

    private fun loadDataFromNetwork() {
        startLoading()

        lifecycleScope.launchWhenCreated {
            openWeatherViewModel.getOpenWeatherFromNetwork(binding.edtcity.text.toString(),"3a46b8f5a2e3d2fcd6c5083afc261630")

            openWeatherViewModel.weather.collect{
                it?.let {
                    openWeatherAdapter= OpenWeatherAdapter(this@OpenWeatherActivity, it.list as List<ListItem>)

                    binding.weatherRv.apply {
                        adapter=openWeatherAdapter
                        hasFixedSize()
                        layoutManager=LinearLayoutManager(this@OpenWeatherActivity,LinearLayoutManager.HORIZONTAL,false)
                    }
                    hideLoading()
                }
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