package com.example.testearquitetura

import android.app.Application
import com.example.testearquitetura.di.KoinInitializer

class TestArchitectureApp : Application() {

    override fun onCreate() {
        super.onCreate()
        KoinInitializer.initialize(this)
    }
}