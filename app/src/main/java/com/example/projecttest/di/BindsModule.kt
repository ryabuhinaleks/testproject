package com.example.projecttest.di

import com.example.projecttest.data.repository.EstateObjectRepositoryImpl
import com.example.projecttest.domain.repository.EstateObjectRepository
import dagger.Binds
import dagger.Module

@Module
interface BindsModule {

    @Binds
    fun bindEstateObjectRepository(impl: EstateObjectRepositoryImpl): EstateObjectRepository
}
