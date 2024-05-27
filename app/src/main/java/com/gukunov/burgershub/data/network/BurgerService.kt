package com.gukunov.burgershub.data.network

import com.gukunov.burgershub.domain.entity.BurgerItem
import com.gukunov.burgershub.domain.entity.BurgerResponse
import retrofit2.http.GET

interface BurgerService {

    @GET("burgers")
    suspend fun getBurgerList(): List<BurgerItem>

}
