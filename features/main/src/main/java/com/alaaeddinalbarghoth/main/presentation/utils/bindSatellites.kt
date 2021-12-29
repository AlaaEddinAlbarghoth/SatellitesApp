package com.alaaeddinalbarghoth.main.presentation.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alaaeddinalbarghoth.cache.model.list.Satellites
import com.alaaeddinalbarghoth.main.presentation.activities.list.adapter.SatelliteClickListener
import com.alaaeddinalbarghoth.main.presentation.activities.list.adapter.SatellitesAdapter

@BindingAdapter("satellites", "satellitesAdapter")
fun RecyclerView.bindSatellites(
    satellites: Satellites,
    satellitesAdapter: SatellitesAdapter,
) {
    this.layoutManager = LinearLayoutManager(
        this.context,
        LinearLayoutManager.VERTICAL,
        false
    )
    satellitesAdapter.submitList(satellites)
    this.adapter = satellitesAdapter
}
