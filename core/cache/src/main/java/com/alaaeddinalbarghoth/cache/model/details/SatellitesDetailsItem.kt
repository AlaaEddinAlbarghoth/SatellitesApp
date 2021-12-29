package com.alaaeddinalbarghoth.cache.model.details

import com.google.gson.annotations.SerializedName

data class SatellitesDetailsItem(
    @SerializedName("cost_per_launch")
    val costPerLaunch: String,
    @SerializedName("first_flight")
    val firstFlight: String,
    val height: String,
    val id: String,
    val mass: String
)
