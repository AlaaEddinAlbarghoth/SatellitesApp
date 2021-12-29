package com.alaaeddinalbarghoth.main.presentation.activities.list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.alaaeddinalbarghoth.cache.model.list.SatellitesItem

class SatelliteDiffUtil : DiffUtil.ItemCallback<SatellitesItem>() {

    override fun areItemsTheSame(oldItem: SatellitesItem, newItem: SatellitesItem): Boolean {
        return oldItem.id === newItem.id
    }

    override fun areContentsTheSame(oldItem: SatellitesItem, newItem: SatellitesItem): Boolean {
        return oldItem == newItem
    }
}