package com.gukunov.burgershub.domain.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

//@Parcelize
//data class BurgerItem(
//    val desc: String? = null,
//    val id: Int? = null,
//    val images: List<Image>  = listOf(),
//    val ingredients: List<Ingredient> = listOf(),
//    val name: String? = null,
//    val price: Double? = null,
//    val veg: Boolean? = null
//): Parcelable

@Parcelize
data class BurgerItem(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("images") var images: List<Image> = listOf(),
    @SerializedName("desc") var desc: String? = null,
    @SerializedName("ingredients") var ingredients: List<Ingredient> = listOf(),
    @SerializedName("price") var price: Double? = null,
    @SerializedName("veg") var veg: Boolean? = null,
) : Parcelable


