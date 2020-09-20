package com.jet2.travel

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TravelApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}