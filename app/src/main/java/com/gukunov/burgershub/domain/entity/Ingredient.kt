package com.gukunov.burgershub.domain.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

//@Parcelize
//data class Ingredient(
//    val id: Int? = null,
//    val img: String? = null,
//    val name: String? = null
//):Parcelable


@Parcelize
data class Ingredient(
    @SerializedName("id"   ) var id   : Int?    = null,
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("img"  ) var img  : String? = null
):Parcelable


