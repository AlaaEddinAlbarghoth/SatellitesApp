package com.alaaeddinalbarghoth.main.presentation.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.alaaeddinalbarghoth.main.R

@BindingAdapter("isActive")
fun TextView.bindSatellites(
    isActive: Boolean
) {
    this.text = if (isActive) {
        this.setTextColor(this.context.getColor(android.R.color.holo_green_dark))
        this.context.getString(R.string.status_active)
    } else {
        this.setTextColor(this.context.getColor(android.R.color.holo_red_dark))
        this.context.getString(R.string.status_stopped)
    }
}
