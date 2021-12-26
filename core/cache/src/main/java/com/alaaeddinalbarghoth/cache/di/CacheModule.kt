package com.alaaeddinalbarghoth.cache.di

import android.content.Context
import com.alaaeddinalbarghoth.cache.repository.SatellitesRepository
import com.alaaeddinalbarghoth.cache.repository.SatellitesRepositoryImpl
import com.alaaeddinalbarghoth.cache.service.SatellitesService
import com.alaaeddinalbarghoth.cache.service.SatellitesServiceImpl
import com.alaaeddinalbarghoth.cache.source.SatellitesLocalDataSource
import com.alaaeddinalbarghoth.utils.dispatcher.DispatcherProvider
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Singleton
    @Provides
    fun provideSatellitesService(
        gson: Gson,
        @ApplicationContext context: Context
    ): SatellitesService =
        SatellitesServiceImpl(gson, context)

    @Provides
    @Singleton
    fun provideSatellitesLocalDataSource(
        satellitesService: SatellitesService
    ): SatellitesLocalDataSource = SatellitesLocalDataSource(satellitesService)

    @Provides
    @Singleton
    fun provideSatellitesRepository(
        dispatcherProvider: DispatcherProvider,
        satellitesLocalDataSource: SatellitesLocalDataSource
    ): SatellitesRepository =
        SatellitesRepositoryImpl(dispatcherProvider, satellitesLocalDataSource)
}
