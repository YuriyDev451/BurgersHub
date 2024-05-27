package com.gukunov.burgershub.domain.useCase.di

import com.gukunov.burgershub.data.repository.BurgerRepositoryInterface
import com.gukunov.burgershub.domain.useCase.GetBurgerListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideUseCase(repositoryInterface: BurgerRepositoryInterface) =
        GetBurgerListUseCase(repositoryInterface)
}