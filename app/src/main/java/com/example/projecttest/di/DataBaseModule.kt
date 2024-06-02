package com.example.projecttest.di

import android.app.Application
import com.example.projecttest.data.database.EstateDataBase
import com.example.projecttest.data.database.dao.EstateObjectDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideEstateObjectDao(estateDataBase: EstateDataBase): EstateObjectDao {
        return estateDataBase.getEstateDao()
    }

    @Singleton
    @Provides
    fun provideEstateDataBase(application: Application): EstateDataBase {
        return EstateDataBase.getInstance(application)
    }
}
