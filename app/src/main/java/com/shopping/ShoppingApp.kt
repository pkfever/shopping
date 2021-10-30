package com.shopping

import android.app.Application
import com.shopping.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ShoppingApp : Application() {

    override fun onCreate() {
        super.onCreate()

        configureDi()
    }

    private fun configureDi() = startKoin {
        androidContext(this@ShoppingApp)
        modules(appComponent)
    }

}