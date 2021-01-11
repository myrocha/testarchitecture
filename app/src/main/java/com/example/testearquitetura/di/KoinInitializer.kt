package com.example.testearquitetura.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

object KoinInitializer {

    private val modules = listOf(contactModule)

    @JvmStatic
    fun initialize(application: Application) {
        startKoin {
            androidContext(application)
            modules(modules)
        }
    }
}