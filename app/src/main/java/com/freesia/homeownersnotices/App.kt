package com.freesia.homeownersnotices

import android.app.Application
import com.freesia.homeownersnotices.di.Di
import com.freesia.homeownersnotices.util.LogDebugTree
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(listOf(
                Di.platform, Di.user,
                Di.network,
                Di.app, Di.viewModels)
            )
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(LogDebugTree)
        }

    }
}