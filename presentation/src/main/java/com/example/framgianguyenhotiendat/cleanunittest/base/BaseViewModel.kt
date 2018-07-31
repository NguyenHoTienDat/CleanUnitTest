package com.example.framgianguyenhotiendat.cleanunittest.base

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModel
import com.example.framgianguyenhotiendat.cleanunittest.domain.usecase.UseCase
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(
        vararg val useCases: UseCase<*, *>?
) : ViewModel(), LifecycleObserver {
    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        useCases.let { if (it.isNotEmpty()) it.forEach { it!!.onCleared() } }
        super.onCleared()
    }
}
