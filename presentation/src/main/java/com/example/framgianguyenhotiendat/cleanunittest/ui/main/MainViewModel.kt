package com.example.framgianguyenhotiendat.cleanunittest.ui.main

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.util.Log
import com.example.framgianguyenhotiendat.cleanunittest.MainApplication
import com.example.framgianguyenhotiendat.cleanunittest.base.BaseViewModel
import com.example.framgianguyenhotiendat.cleanunittest.domain.usecase.GetStoriesUseCase
import com.example.framgianguyenhotiendat.cleanunittest.model.StoryItem
import com.example.framgianguyenhotiendat.cleanunittest.model.StoryItemMapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(
        val topStoriesUseCase: GetStoriesUseCase,
        val itemMapper: StoryItemMapper
) : BaseViewModel(topStoriesUseCase) {

    val stories = MutableLiveData<List<StoryItem>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun startViewModel() {
        topStoriesUseCase.createObservable(GetStoriesUseCase.Params("health", 5))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map { it.map { itemMapper.mapToPresentation(it) } }
                .subscribe({
                    stories.value = it
                }, {})
    }
}
