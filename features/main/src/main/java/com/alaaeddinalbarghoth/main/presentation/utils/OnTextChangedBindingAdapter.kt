package com.alaaeddinalbarghoth.main.presentation.utils

import android.widget.EditText
import androidx.annotation.NonNull
import androidx.core.widget.doOnTextChanged
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import com.alaaeddinalbarghoth.main.presentation.activities.list.SatellitesViewModel

@BindingAdapter("onSearchQueryChanged")
fun EditText.onTextChangedBindingAdapter(
    @NonNull viewModel: SatellitesViewModel
) {
    this.doOnTextChanged { text, _, _, _ ->
        viewModel.search(text.toString())
    }
}