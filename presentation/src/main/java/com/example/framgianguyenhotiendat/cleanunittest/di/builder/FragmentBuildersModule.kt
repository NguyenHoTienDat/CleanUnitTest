package com.example.framgianguyenhotiendat.cleanunittest.di.builder

import com.example.framgianguyenhotiendat.cleanunittest.ui.main.MainFragment
import com.example.framgianguyenhotiendat.cleanunittest.ui.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashFragment
}
