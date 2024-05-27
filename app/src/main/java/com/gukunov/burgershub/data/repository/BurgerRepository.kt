package com.gukunov.burgershub.data.repository

import com.gukunov.burgershub.data.network.BurgerService
import com.gukunov.burgershub.domain.entity.BurgerItem
import com.gukunov.burgershub.domain.entity.BurgerResponse
import javax.inject.Inject

interface BurgerRepositoryInterface{
    suspend fun getBurgerList(): List<BurgerItem>
}

class BurgerRepository @Inject constructor(private val burgerService: BurgerService): BurgerRepositoryInterface {
    override suspend fun getBurgerList(): List<BurgerItem> {
        return burgerService.getBurgerList()
    }
}