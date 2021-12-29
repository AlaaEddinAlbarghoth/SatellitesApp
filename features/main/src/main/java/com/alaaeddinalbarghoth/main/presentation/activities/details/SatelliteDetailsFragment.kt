package com.alaaeddinalbarghoth.main.presentation.activities.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.alaaeddinalbarghoth.main.databinding.FragmentSatelliteDetailsBinding
import com.alaaeddinalbarghoth.main.presentation.activities.SatellitesActivity
import com.alaaeddinalbarghoth.main.presentation.utils.BaseFragment
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class SatelliteDetailsFragment : BaseFragment() {

    private val args: SatelliteDetailsFragmentArgs by navArgs()
    private val viewModel: SatelliteDetailsViewModel by viewModels()
    private lateinit var fragmentSatelliteDetailsBinding: FragmentSatelliteDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = let {
        fragmentSatelliteDetailsBinding =
            FragmentSatelliteDetailsBinding.inflate(inflater, container, false)
        fragmentSatelliteDetailsBinding.lifecycleOwner = viewLifecycleOwner
        fragmentSatelliteDetailsBinding.viewModel = viewModel
        fragmentSatelliteDetailsBinding.root
    }

    override fun onResume() {
        super.onResume()

        fragmentSatelliteDetailsBinding.btnBack.setOnClickListener {
            (requireActivity() as SatellitesActivity).navigationPopup()
        }

        viewModel.loadSatellitesDetails(args.satellitesItem)

        lifecycleScope.launchWhenResumed {

            viewModel.loadState.collectLatest { show ->
                if (show)
                    showLoadingDialog()
                else
                    hideProgressBarDialog()
            }

            viewModel.errorMessage.collectLatest { message ->
                Snackbar.make(fragmentSatelliteDetailsBinding.root, message, Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }
}
