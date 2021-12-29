package com.alaaeddinalbarghoth.main.presentation.activities.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alaaeddinalbarghoth.cache.model.list.SatellitesItem
import com.alaaeddinalbarghoth.main.R
import com.alaaeddinalbarghoth.main.databinding.ItemSatelliteBinding

class SatellitesAdapter : ListAdapter<SatellitesItem, SatellitesAdapter.SatellitesViewHolder>
    (SatelliteDiffUtil()) {

    var satelliteClickListener: SatelliteClickListener? = null

    // region Adapter
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SatellitesAdapter.SatellitesViewHolder {
        return SatellitesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_satellite,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SatellitesAdapter.SatellitesViewHolder, position: Int) {
        holder.itemSatelliteBinding.satellitesItem = getItem(position)
        holder.itemSatelliteBinding.listener = satelliteClickListener

        setSatelliteIcon(holder, position)
        setItemBackgroundColor(holder, position)
    }

    private fun setItemBackgroundColor(
        holder: SatellitesViewHolder,
        position: Int
    ) {
        val colorList = listOf(
            R.color.light_green_3,
            R.color.s_1_ue_violet_3,
            R.color.button_blue,
            R.color.orange_yellow_1
        )

        holder.itemSatelliteBinding.cvItem.setCardBackgroundColor(
            ContextCompat.getColor(
                holder.itemSatelliteBinding.cvItem.context,
                colorList[(position + 1) % colorList.size]
            )
        )
    }

    private fun setSatelliteIcon(
        holder: SatellitesViewHolder,
        position: Int
    ) {
        val iconsList = listOf(
            R.drawable.ic_sat1,
            R.drawable.ic_sat2,
            R.drawable.ic_sat3,
            R.drawable.ic_sat4
        )

        holder.itemSatelliteBinding.ivSatellite.setImageDrawable(
            ContextCompat.getDrawable(
                holder.itemSatelliteBinding.cvItem.context,
                iconsList[(position + 1) % iconsList.size]
            )
        )
    }
    // endregion

    // region ViewHolder
    inner class SatellitesViewHolder(val itemSatelliteBinding: ItemSatelliteBinding) :
        RecyclerView.ViewHolder(itemSatelliteBinding.root)
    // endregion

}