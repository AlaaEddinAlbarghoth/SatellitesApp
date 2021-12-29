package com.alaaeddinalbarghoth.main.presentation.dialogs

import android.app.Dialog
import android.content.Context
import com.alaaeddinalbarghoth.main.R

class LoadingDialog(context: Context) : Dialog(context, R.style.DialogStyle) {

    init {
        setContentView(R.layout.dialog_loading)
        setCanceledOnTouchOutside(false)
        setCancelable(false)
    }
}