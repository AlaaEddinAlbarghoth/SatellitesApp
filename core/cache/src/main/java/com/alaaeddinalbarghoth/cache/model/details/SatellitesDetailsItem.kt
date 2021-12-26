package com.alaaeddinalbarghoth.cache.model.details

import kotlinx.serialization.SerialName

data class SatellitesDetailsItem(
    @SerialName("cost_per_launch")
    val costPerLaunch: Int,
    @SerialName("first_flight")
    val firstFlight: String,
    val height: Int,
    val id: Int,
    val mass: Int
)
