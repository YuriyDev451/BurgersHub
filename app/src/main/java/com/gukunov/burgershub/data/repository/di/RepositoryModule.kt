package com.gukunov.burgershub.data.repository.di

import com.gukunov.burgershub.data.repository.BurgerRepository
import com.gukunov.burgershub.data.repository.BurgerRepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideBurgerRepository(repository: BurgerRepository): BurgerRepositoryInterface
}
