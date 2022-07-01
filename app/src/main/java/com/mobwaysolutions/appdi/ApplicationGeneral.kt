package com.mobwaysolutions.appdi

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ApplicationGeneral : Application() {

    override fun onCreate() {
        super.onCreate()

    }

}
