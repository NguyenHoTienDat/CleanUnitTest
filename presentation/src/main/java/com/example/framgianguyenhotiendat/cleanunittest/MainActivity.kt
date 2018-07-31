package com.example.framgianguyenhotiendat.cleanunittest

import android.os.Bundle
import android.util.Log
import com.example.framgianguyenhotiendat.cleanunittest.base.BaseActivity
import com.example.framgianguyenhotiendat.cleanunittest.domain.usecase.GetStoriesUseCase
import com.example.framgianguyenhotiendat.cleanunittest.model.StoryItemMapper
import com.example.framgianguyenhotiendat.cleanunittest.ui.main.MainFragment
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()

        }
    }
}
