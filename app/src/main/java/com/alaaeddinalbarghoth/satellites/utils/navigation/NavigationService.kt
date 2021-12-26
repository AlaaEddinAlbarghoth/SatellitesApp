package com.alaaeddinalbarghoth.satellites.utils.navigation

import android.os.Bundle

/** A Service that control navigation between the activities components in the app
 * Also it simplifies the control the navigation from the business logic of the ui */
interface NavigationService {

    fun finishActivity()

    fun navigateToActivity(screen: Screen, finishCurrent: Boolean = true)

    fun navigateToActivity(screen: Screen, bundle: Bundle, finishCurrent: Boolean = true)
}
