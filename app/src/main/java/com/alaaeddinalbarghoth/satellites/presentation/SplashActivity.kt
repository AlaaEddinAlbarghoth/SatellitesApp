package com.alaaeddinalbarghoth.satellites.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.alaaeddinalbarghoth.satellites.R
import com.alaaeddinalbarghoth.satellites.utils.base.BaseActivity
import com.alaaeddinalbarghoth.satellites.utils.navigation.NavigationService
import com.alaaeddinalbarghoth.satellites.utils.navigation.Screen.Satellites
import com.alaaeddinalbarghoth.utils.constants.SPLASH_DELAY_TIME
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    @Inject
    lateinit var navigationService: NavigationService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed(
            {
                navigationService.navigateToActivity(Satellites)
            },
            SPLASH_DELAY_TIME
        )
    }
}
