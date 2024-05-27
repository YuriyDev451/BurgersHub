package com.gukunov.burgershub.domain.useCase

import com.gukunov.burgershub.common.Resource
import com.gukunov.burgershub.data.repository.BurgerRepository
import com.gukunov.burgershub.data.repository.BurgerRepositoryInterface
import com.gukunov.burgershub.domain.entity.BurgerItem
import com.gukunov.burgershub.domain.entity.BurgerResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetBurgerListUseCase @Inject constructor(private val burgerRepositoryInterface: BurgerRepositoryInterface){
     fun execute() = flow {
        emit(Resource.Loading())
        burgerRepositoryInterface.getBurgerList()?.let {
            emit(Resource.Success(it))
        }?:emit(Resource.Error("Error"))
    }.catch {
        emit(Resource.Error(it.localizedMessage))
    }

}