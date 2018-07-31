package com.example.framgianguyenhotiendat.cleanunittest.di.builder

import android.app.Application
import android.content.Context
import com.example.framgianguyenhotiendat.cleanunittest.data.di.NetworkModule
import com.example.framgianguyenhotiendat.cleanunittest.data.di.RepositoryModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, NetworkModule::class, RepositoryModule::class])
class AppModule {

    @Singleton
    @Provides
    fun providerContext(application: Application): Context {
        return application
    }

}
