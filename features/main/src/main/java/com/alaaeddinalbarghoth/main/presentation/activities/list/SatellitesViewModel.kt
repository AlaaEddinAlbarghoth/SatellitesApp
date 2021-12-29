package com.alaaeddinalbarghoth.main.presentation.activities.list

import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alaaeddinalbarghoth.cache.model.list.Satellites
import com.alaaeddinalbarghoth.cache.model.list.SatellitesItem
import com.alaaeddinalbarghoth.main.presentation.activities.list.adapter.SatelliteClickListener
import com.alaaeddinalbarghoth.main.presentation.activities.list.adapter.SatellitesAdapter
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
class SatellitesViewModel @Inject constructor(
    val satellitesAdapter: SatellitesAdapter,
    private val satellitesUseCase: SatellitesUseCase
) : ViewModel(), SatelliteClickListener {

    private val _empty = MutableStateFlow(false)
    val empty = _empty.asStateFlow()

    private val _loadState = MutableStateFlow(false)
    val loadState = _loadState.asStateFlow()

    private val _errorMessage = MutableSharedFlow<String>()
    val errorMessage = _errorMessage.asSharedFlow()

    private val _satellitesItem = MutableLiveData<SatellitesItem>()
    val satellitesItem: LiveData<SatellitesItem> = _satellitesItem

    private var _satellites = MutableStateFlow(Satellites())
        set(value) = satellitesAdapter.submitList(value.value)
    val satellites = _satellites.asStateFlow()

    val searchQuery = MutableLiveData("")
    var editorActionListener: TextView.OnEditorActionListener =
        TextView.OnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                if (searchQuery.value.isNullOrEmpty())
                    viewModelScope.launch {
                        loadSatellites()
                    }
                else
                    search(searchQuery.value.toString())
                true
            } else false
        }

    init {
        satellitesAdapter.satelliteClickListener = this@SatellitesViewModel

        viewModelScope.launch {
            loadSatellites()
        }
    }

    private suspend fun loadSatellites() {
        _loadState.value = true

        when (val result = satellitesUseCase.getSatellitesList()) {
            is Empty -> {
                _empty.value = true
                _loadState.value = false
            }
            is Success -> {
                delay(500) // Just to give some reality
                _empty.value = false
                _loadState.value = false
                _satellites.value = result.data!!
            }
            is Error -> {
                _empty.value = false
                _loadState.value = false
                _errorMessage.emit(result.errorMessage.orEmpty())
            }
        }
    }

    fun search(searchQuery: String) {
        _loadState.value = true

        viewModelScope.launch {

            if (searchQuery.isEmpty())
                loadSatellites()
            else
                when (val result = satellitesUseCase.searchSatellites(searchQuery)) {
                    is Empty -> {
                        _empty.value = true
                        _loadState.value = false
                    }
                    is Success -> {
                        delay(500) // Just to give some reality
                        _empty.value = false
                        _loadState.value = false
                        _satellites.value = result.data!!
                    }
                    is Error -> {
                        _empty.value = false
                        _loadState.value = false
                        _errorMessage.emit(result.errorMessage.orEmpty())
                    }
                }
        }
    }

    /* Needs to refactor */
    override fun onClick(satellitesItem: SatellitesItem) {
        _satellitesItem.value = satellitesItem
    }
}
