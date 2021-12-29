package com.alaaeddinalbarghoth.main.usecase

import com.alaaeddinalbarghoth.cache.model.details.SatellitesDetailsItem
import com.alaaeddinalbarghoth.cache.model.list.Satellites
import com.alaaeddinalbarghoth.cache.model.positions.PositionsInfo
import com.alaaeddinalbarghoth.utils.results.DataResult

interface SatellitesUseCase {

    suspend fun getSatellitesList(): DataResult<Satellites>

    suspend fun searchSatellites(searchQuery: String): DataResult<Satellites>

    suspend fun getSatellitesDetailsItemById(id: String): DataResult<SatellitesDetailsItem>

    suspend fun getPositionsBySatelliteId(id: String): DataResult<PositionsInfo>

}
