package com.alaaeddinalbarghoth.satellites.utils.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alaaeddinalbarghoth.main.presentation.activities.SatellitesActivity
import com.alaaeddinalbarghoth.satellites.utils.navigation.NavigationService
import com.alaaeddinalbarghoth.satellites.utils.navigation.Screen
import com.alaaeddinalbarghoth.satellites.utils.navigation.Screen.Satellites

/** Base Class to share common functionalities */
abstract class BaseActivity : AppCompatActivity(), NavigationService {

    override fun navigateToActivity(screen: Screen, finishCurrent: Boolean) {
        startActivity(
            Intent(
                this,
                when (screen) {
                    Satellites -> SatellitesActivity::class.java
                }
            )
        )

        if (finishCurrent)
            finish()
    }
}
