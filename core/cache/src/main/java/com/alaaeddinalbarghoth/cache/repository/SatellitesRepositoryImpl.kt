package com.alaaeddinalbarghoth.cache.repository

import com.alaaeddinalbarghoth.cache.model.details.SatellitesDetails
import com.alaaeddinalbarghoth.cache.model.list.Satellites
import com.alaaeddinalbarghoth.cache.model.positions.PositionsInfo
import com.alaaeddinalbarghoth.cache.source.SatellitesLocalDataSource
import com.alaaeddinalbarghoth.utils.dispatcher.DispatcherProvider
import com.alaaeddinalbarghoth.utils.results.DataResult

/** Here you can manage the states of the data coming from local data source */
class SatellitesRepositoryImpl(
    private val dispatcher: DispatcherProvider,
    private val satellitesLocalDataSource: SatellitesLocalDataSource,
) : SatellitesRepository {

    override suspend fun getSatellitesList(): DataResult<Satellites> =
        satellitesLocalDataSource.getSatellitesList(dispatcher.io)

    override suspend fun getSatellitesDetails(): DataResult<SatellitesDetails> =
        satellitesLocalDataSource.getSatellitesDetails(dispatcher.io)

    override suspend fun getPositionsInfo(): DataResult<PositionsInfo> =
        satellitesLocalDataSource.getPositionsInfo(dispatcher.io)
}
