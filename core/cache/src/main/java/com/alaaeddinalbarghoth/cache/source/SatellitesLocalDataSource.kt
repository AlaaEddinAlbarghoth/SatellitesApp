package com.alaaeddinalbarghoth.cache.source

import com.alaaeddinalbarghoth.cache.service.SatellitesService
import kotlinx.coroutines.CoroutineDispatcher

class SatellitesLocalDataSource(
    private val satellitesService: SatellitesService
) : LocalDataSource() {

    suspend fun getSatellitesList(dispatcher: CoroutineDispatcher) =
        safeLoadJson(dispatcher) {
            satellitesService.getSatellitesList()
        }

    suspend fun getSatellitesDetails(dispatcher: CoroutineDispatcher) =
        safeLoadJson(dispatcher) {
            satellitesService.getSatellitesDetails()
        }

    suspend fun getPositionsInfo(dispatcher: CoroutineDispatcher) =
        safeLoadJson(dispatcher) {
            satellitesService.getPositionsInfo()
        }
}
