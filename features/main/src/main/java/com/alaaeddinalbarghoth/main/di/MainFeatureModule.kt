package com.alaaeddinalbarghoth.main.di

import com.alaaeddinalbarghoth.cache.repository.SatellitesRepository
import com.alaaeddinalbarghoth.main.presentation.activities.list.adapter.SatellitesAdapter
import com.alaaeddinalbarghoth.main.usecase.SatellitesUseCase
import com.alaaeddinalbarghoth.main.usecase.SatellitesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MainFeatureModule {

    @Provides
    fun provideSatellitesAdapter() = SatellitesAdapter()

    @Provides
    fun provideSatellitesUseCase(satellitesRepository: SatellitesRepository): SatellitesUseCase =
        SatellitesUseCaseImpl(satellitesRepository)
}