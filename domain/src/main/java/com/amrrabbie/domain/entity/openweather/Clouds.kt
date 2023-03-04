package com.amrrabbie.domain.entity.openweather

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Clouds(

	@field:SerializedName("all")
	val all: Int? = null
) : Parcelable