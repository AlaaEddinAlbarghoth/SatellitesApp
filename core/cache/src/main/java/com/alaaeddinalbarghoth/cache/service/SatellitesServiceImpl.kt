package com.alaaeddinalbarghoth.cache.service

import android.content.Context
import com.alaaeddinalbarghoth.cache.model.details.SatellitesDetails
import com.alaaeddinalbarghoth.cache.model.list.Satellites
import com.alaaeddinalbarghoth.cache.model.positions.Positions
import com.alaaeddinalbarghoth.cache.model.positions.PositionsInfo
import com.google.gson.Gson
import java.io.InputStream
import java.nio.charset.Charset

class SatellitesServiceImpl(
    private val gson: Gson,
    private val context: Context
) : SatellitesService {

    override suspend fun getSatellitesList(): Satellites {
        return gson.fromJson(
            getContainsFromAssetFile("satellite-list.json"),
            Satellites::class.java
        )
    }

    override suspend fun getSatellitesDetails(): SatellitesDetails {
        return gson.fromJson(
            getContainsFromAssetFile("satellite-detail.json"),
            SatellitesDetails::class.java
        )
    }

    override suspend fun getPositionsInfo(): Positions {
        return gson.fromJson(
            getContainsFromAssetFile("positions.json"),
            Positions::class.java
        )
    }

    @Suppress("BlockingMethodInNonBlockingContext")
    fun getContainsFromAssetFile(fileName: String): String {
        val inputStream: InputStream = context.assets.open(fileName)
        val buffer = ByteArray(inputStream.available())
        inputStream.read(buffer)
        inputStream.close()
        return String(buffer, Charset.forName("UTF-8"))
    }
}
