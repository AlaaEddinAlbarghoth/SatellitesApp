package com.alaaeddinalbarghoth.main.presentation.activities.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.alaaeddinalbarghoth.main.databinding.FragmentSatellitesBinding
import com.alaaeddinalbarghoth.main.presentation.activities.SatellitesActivity
import com.alaaeddinalbarghoth.main.presentation.utils.BaseFragment
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SatellitesFragment : BaseFragment() {

    private val viewModel: SatellitesViewModel by viewModels()
    private lateinit var fragmentSatellitesBinding: FragmentSatellitesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {

            repeatOnLifecycle(Lifecycle.State.STARTED) {

                viewModel.loadState.collectLatest { show ->
                    if (show)
                        showLoadingDialog()
                    else
                        hideProgressBarDialog()
                }

                viewModel.errorMessage.collectLatest { message ->
                    Snackbar.make(fragmentSatellitesBinding.root, message, Snackbar.LENGTH_LONG)
                        .show()
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = let {
        fragmentSatellitesBinding = FragmentSatellitesBinding.inflate(inflater, container, false)
        fragmentSatellitesBinding.lifecycleOwner = viewLifecycleOwner
        fragmentSatellitesBinding.viewModel = viewModel
        fragmentSatellitesBinding.root
    }

    override fun onResume() {
        super.onResume()

        viewModel.satellitesItem.observe(viewLifecycleOwner) { satellitesItem ->
            (requireActivity() as SatellitesActivity).navigateToDetails(satellitesItem)
        }
    }
}
