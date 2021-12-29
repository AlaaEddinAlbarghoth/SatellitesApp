package com.alaaeddinalbarghoth.main.usecase

import com.alaaeddinalbarghoth.cache.model.details.SatellitesDetailsItem
import com.alaaeddinalbarghoth.cache.model.list.Satellites
import com.alaaeddinalbarghoth.cache.model.positions.PositionsInfo
import com.alaaeddinalbarghoth.cache.repository.SatellitesRepository
import com.alaaeddinalbarghoth.utils.results.*

class SatellitesUseCaseImpl(
    private val satellitesRepository: SatellitesRepository
) : SatellitesUseCase {

    override suspend fun getSatellitesList(): DataResult<Satellites> =
        satellitesRepository.getSatellitesList()

    override suspend fun searchSatellites(searchQuery: String): DataResult<Satellites> =
        when (val result = satellitesRepository.getSatellitesList()) {
            is Empty -> Empty
            is Success -> {
                if (result.data.isNullOrEmpty())
                    Empty
                else
                    result.data?.filter { it.name.contains(searchQuery) }.let { filteredList ->
                        if (filteredList.isNullOrEmpty())
                            Empty
                        else
                            Success(Satellites().apply { addAll(filteredList) })
                    }
            }
            is Error -> Error(result.errorMessage)
        }

    override suspend fun getSatellitesDetailsItemById(id: String): DataResult<SatellitesDetailsItem> =
        when (val result = satellitesRepository.getSatellitesDetails()) {
            is Empty -> Empty
            is Success -> {
                if (result.data.isNullOrEmpty())
                    Empty
                else {
                    result.data.let { data ->
                        data?.first { it.id == id }.let { item ->
                            if (item == null)
                                Empty
                            else
                                Success(item)
                        }
                    }
                }
            }
            is Error -> Error(result.errorMessage)
        }

    override suspend fun getPositionsBySatelliteId(id: String): DataResult<PositionsInfo> =
        when (val result = satellitesRepository.getPositionsInfo()) {
            is Empty -> Empty
            is Success -> {
                if (result.data?.list.isNullOrEmpty())
                    Empty
                else {
                    result.data?.list?.first { it.id == id }.let { item ->
                        if (item == null)
                            Empty
                        else
                            Success(item)
                    }
                }
            }
            is Error -> Error(result.errorMessage)
        }
}
