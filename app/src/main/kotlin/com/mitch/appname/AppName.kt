package com.mitch.appname

import android.app.Application
import com.mitch.appname.util.CustomTimberTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class AppName : Application() {

    override fun onCreate() {
        super.onCreate()

        // BuildConfig will be created after first run of the app
        if (BuildConfig.DEBUG) {
            Timber.plant(CustomTimberTree())
        }
    }
}
