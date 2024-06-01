package com.example.projecttest

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.projecttest.data.database.EstateDataBase
import com.example.projecttest.data.database.dao.EstateObjectDao

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        estateDatabase =
            EstateDataBase.getInstance(applicationContext)
        estateDb = estateDatabase.getEstateDao()
    }

    companion object {
        lateinit var estateDatabase: EstateDataBase
        lateinit var estateDb: EstateObjectDao
    }
}