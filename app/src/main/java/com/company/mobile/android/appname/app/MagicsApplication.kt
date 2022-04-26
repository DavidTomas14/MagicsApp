package com.company.mobile.android.appname.app

import android.app.Application
import com.company.mobile.android.appname.app.common.log.TimberLogImplementation
import com.company.mobile.android.appname.app.di.applicationModule
import com.company.mobile.android.appname.app.di.cardsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MagicsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // start Koin!
        startKoin {
            // Android context
            androidContext(this@MagicsApplication)
            // modules
            modules(listOf(applicationModule, cardsModule))
        }

        // Initialize logging library
        TimberLogImplementation.init()
    }
}
