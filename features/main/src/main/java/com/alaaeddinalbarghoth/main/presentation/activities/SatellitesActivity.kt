package com.alaaeddinalbarghoth.main.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.alaaeddinalbarghoth.cache.model.list.SatellitesItem
import com.alaaeddinalbarghoth.main.R
import com.alaaeddinalbarghoth.main.presentation.activities.list.SatellitesFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SatellitesActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_satellites)

        setupNavigation()
    }

    private fun setupNavigation() {
        navController =
            (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment).navController
    }

    fun navigationPopup() {
        if (navController.popBackStack())
            navController.navigateUp()
        else
            finish()
    }

    fun navigateToDetails(satellitesItem: SatellitesItem) {
        navController.navigate(
            SatellitesFragmentDirections
                .actionSatellitesFragmentToSatelliteDetailsFragment(satellitesItem)
        )
    }
}
