package com.alaaeddinalbarghoth.cache.repository

import com.alaaeddinalbarghoth.cache.model.details.SatellitesDetails
import com.alaaeddinalbarghoth.cache.model.list.Satellites
import com.alaaeddinalbarghoth.cache.model.positions.Positions
import com.alaaeddinalbarghoth.utils.results.DataResult

interface SatellitesRepository {

    suspend fun getSatellitesList(): DataResult<Satellites>

    suspend fun getSatellitesDetails(): DataResult<SatellitesDetails>

    suspend fun getPositionsInfo(): DataResult<Positions>
}
