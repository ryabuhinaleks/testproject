package com.example.projecttest.di

import android.app.Application
import com.example.projecttest.presentation.screen.detail.EstateDetailFragment
import com.example.projecttest.presentation.screen.estatelist.EstateListFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [BindsModule::class, DataBaseModule::class]
)
interface ApplicationComponent {
    fun inject(fragment: EstateListFragment)
    fun inject(fragment: EstateDetailFragment)

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}