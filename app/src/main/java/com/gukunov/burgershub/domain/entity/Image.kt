package com.gukunov.burgershub.domain.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

//@Parcelize
//data class Image(
//    val lg: String? = null,
//    val sm: String? = null
//): Parcelable



@Parcelize
data class Image(
    @SerializedName("sm" ) var sm : String? = null,
    @SerializedName("lg" ) var lg: String? = null
): Parcelable