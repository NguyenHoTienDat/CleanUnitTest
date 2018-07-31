package com.example.framgianguyenhotiendat.cleanunittest.di.component

import android.app.Application
import com.example.framgianguyenhotiendat.cleanunittest.MainApplication
import com.example.framgianguyenhotiendat.cleanunittest.di.builder.ActivityBuilder
import com.example.framgianguyenhotiendat.cleanunittest.di.builder.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicaiton(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(mainApplication: MainApplication)
}
