package dev.clarine.contact

import android.app.Application
import android.content.Context

class contactApp :Application() {
    companion object{
        lateinit var appContext:Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }
}