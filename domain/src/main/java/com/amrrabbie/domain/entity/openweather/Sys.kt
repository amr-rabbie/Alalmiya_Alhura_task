package com.amrrabbie.domain.entity.openweather

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Sys(

	@field:SerializedName("pod")
	val pod: String? = null
) : Parcelable