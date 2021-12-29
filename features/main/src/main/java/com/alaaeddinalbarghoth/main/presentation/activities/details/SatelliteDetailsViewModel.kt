package com.alaaeddinalbarghoth.main.presentation.activities.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alaaeddinalbarghoth.cache.model.details.SatellitesDetailsItem
import com.alaaeddinalbarghoth.cache.model.list.SatellitesItem
import com.alaaeddinalbarghoth.cache.model.positions.Position
import com.alaaeddinalbarghoth.cache.model.positions.Positions
import com.alaaeddinalbarghoth.cache.model.positions.PositionsInfo
import com.alaaeddinalbarghoth.main.usecase.SatellitesUseCase
import com.alaaeddinalbarghoth.utils.results.Empty
import com.alaaeddinalbarghoth.utils.results.Error
import com.alaaeddinalbarghoth.utils.results.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SatelliteDetailsViewModel @Inject constructor(
    private val satellitesUseCase: SatellitesUseCase
) : ViewModel() {

    private val _empty = MutableStateFlow(false)
    val empty = _empty.asStateFlow()

    private val _loadState = MutableStateFlow(false)
    val loadState = _loadState.asStateFlow()

    private val _errorMessage = MutableSharedFlow<String>()
    val errorMessage = _errorMessage.asSharedFlow()

    private val _satelliteName = MutableStateFlow("")
    val satelliteName = _satelliteName.asStateFlow()

    private val _latestPosition by lazy { MutableLiveData<Position>() }
    val latestPosition = _latestPosition as LiveData<Position>

    private val _positions by lazy { MutableLiveData<PositionsInfo>() }
    val positions = _positions as LiveData<PositionsInfo>

    private val _satellitesDetailsItem by lazy {
        MutableLiveData<SatellitesDetailsItem>()
    }
    val satellitesDetailsItem = _satellitesDetailsItem as LiveData<SatellitesDetailsItem>

    fun loadSatellitesDetails(satellitesItem: SatellitesItem) {
        _loadState.value = true

        viewModelScope.launch {
            _satelliteName.emit(satellitesItem.name)

            when (val result = satellitesUseCase.getSatellitesDetailsItemById(satellitesItem.id)) {
                is Empty -> {
                    _empty.value = true
                    _loadState.value = false
                }
                is Success -> {
                    delay(500) // Just to give some reality
                    _empty.value = false
                    _loadState.value = false
                    _satellitesDetailsItem.value = result.data!!
                    loadSatellitesPositions(satellitesItem.id)
                }
                is Error -> {
                    _empty.value = false
                    _loadState.value = false
                    _errorMessage.emit(result.errorMessage.orEmpty())
                }
            }
        }
    }

    suspend fun loadSatellitesPositions(satelliteId: String) {
        when (val result = satellitesUseCase.getPositionsBySatelliteId(satelliteId)) {
            is Empty -> {
                _empty.value = true
                _loadState.value = false
            }
            is Success -> {
                delay(500) // Just to give some reality
                _empty.value = false
                _loadState.value = false
                _positions.value = result.data!!

                showLatestPosition()
            }
            is Error -> {
                _empty.value = false
                _loadState.value = false
                _errorMessage.emit(result.errorMessage.orEmpty())
            }
        }
    }

    private fun showLatestPosition() {
        viewModelScope.launch {
            var i = 0
            while (true) {
                delay(3000)
                positions.value?.positions?.let { list ->
                    _latestPosition.value = list[i++ % list.size]
                }
            }
        }
    }
}
