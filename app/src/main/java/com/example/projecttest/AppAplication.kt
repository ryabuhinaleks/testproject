package com.example.projecttest

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.projecttest.data.database.EstateDataBase
import com.example.projecttest.data.database.dao.EstateObjectDao
import com.example.projecttest.di.DaggerApplicationComponent

class AppApplication : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}