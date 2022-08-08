package com.app.vama

import android.app.Application
import com.app.vama.di.appModule
import com.app.vama.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class VamaApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin()
    }

    private fun startKoin() {
        startKoin {
            androidLogger()
            androidContext(this@VamaApplication)
            modules(appModule + networkModule)
        }
    }
}