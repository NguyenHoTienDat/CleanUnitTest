package com.example.framgianguyenhotiendat.cleanunittest.di.builder

import com.example.framgianguyenhotiendat.cleanunittest.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity
}