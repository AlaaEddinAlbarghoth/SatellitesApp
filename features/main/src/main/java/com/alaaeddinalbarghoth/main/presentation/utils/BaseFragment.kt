package com.alaaeddinalbarghoth.main.presentation.utils

import androidx.fragment.app.Fragment
import com.alaaeddinalbarghoth.main.presentation.dialogs.LoadingDialog

abstract class BaseFragment : Fragment(), DialogService {

    private lateinit var loadingDialog: LoadingDialog

    override fun showLoadingDialog() {
        if (!this::loadingDialog.isInitialized)
            loadingDialog = LoadingDialog(this.requireContext())

        loadingDialog.show()
    }

    override fun hideProgressBarDialog() {
        if (this::loadingDialog.isInitialized)
            loadingDialog.dismiss()
    }
}