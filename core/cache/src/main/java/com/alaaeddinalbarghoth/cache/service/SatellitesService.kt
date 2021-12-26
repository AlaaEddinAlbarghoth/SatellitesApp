package com.alaaeddinalbarghoth.cache.service

import com.alaaeddinalbarghoth.cache.model.details.SatellitesDetails
import com.alaaeddinalbarghoth.cache.model.list.Satellites
import com.alaaeddinalbarghoth.cache.model.positions.PositionsInfo

interface SatellitesService {

    suspend fun getSatellitesList() : Satellites

    suspend fun getSatellitesDetails() : SatellitesDetails

    suspend fun getPositionsInfo() : PositionsInfo
}
