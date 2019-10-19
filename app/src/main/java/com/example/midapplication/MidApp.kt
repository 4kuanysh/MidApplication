package com.example.midapplication

import android.app.Application
import com.example.midapplication.di.dbModule
import com.example.midapplication.di.repoModule
import com.example.midapplication.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MidApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(listOf(dbModule, repoModule, viewModelModule))
        }
    }
}