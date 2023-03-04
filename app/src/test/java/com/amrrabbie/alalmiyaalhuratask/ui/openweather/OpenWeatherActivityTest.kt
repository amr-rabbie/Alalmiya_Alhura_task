package com.amrrabbie.alalmiyaalhuratask.ui.openweather

import android.view.View
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.amrrabbie.alalmiyaalhuratask.R
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class OpenWeatherActivityTest {

    @Rule
    var mActivityTestRule: ActivityScenarioRule<OpenWeatherActivity> = ActivityScenarioRule<OpenWeatherActivity>(
        OpenWeatherActivity::class.java
    )

    private val mActivity: OpenWeatherActivity? = null

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }


    @Test
    fun testLaunch() {
        val v: View = mActivity!!.findViewById(R.id.edtcity)
        assertNotNull(v)
    }


    @Test
    fun getBinding() {
    }

    @Test
    fun setBinding() {
    }

    @Test
    fun getOpenWeatherAdapter() {
    }

    @Test
    fun setOpenWeatherAdapter() {
    }

    @Test
    fun getOpenWeatherAdapterOffline() {
    }

    @Test
    fun setOpenWeatherAdapterOffline() {
    }

    @Test
    fun getOpenWeatherViewModel() {
    }

    @Test
    fun onCreate() {
    }
}