package com.alaaeddinalbarghoth.cache.model.list

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SatellitesItem(
    val id: String,
    val name: String,
    val active: Boolean
) : Parcelable
