package com.example.projecttest

import android.app.Application
import com.example.projecttest.di.DaggerApplicationComponent

class AppApplication : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}