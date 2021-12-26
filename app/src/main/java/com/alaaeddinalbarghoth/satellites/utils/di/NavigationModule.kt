package com.alaaeddinalbarghoth.satellites.utils.di

import android.app.Activity
import com.alaaeddinalbarghoth.satellites.utils.base.BaseActivity
import com.alaaeddinalbarghoth.satellites.utils.navigation.NavigationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object NavigationModule {

    @Provides
    fun provideBaseActivity(activity: Activity): BaseActivity = activity as BaseActivity

    @Provides
    fun provideNavigationService(baseActivity: BaseActivity): NavigationService = baseActivity
}
