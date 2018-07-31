package com.example.framgianguyenhotiendat.cleanunittest.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.framgianguyenhotiendat.cleanunittest.BR
import com.example.framgianguyenhotiendat.cleanunittest.R
import com.example.framgianguyenhotiendat.cleanunittest.base.BaseFragment
import com.example.framgianguyenhotiendat.cleanunittest.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {

    companion object {
        fun newInstance() = MainFragment()
    }

    override val bindingVariable: Int
        get() = BR.viewModel

    override val viewModel: MainViewModel
        get() = ViewModelProviders.of(this, viewModelFactory)
                .get(MainViewModel::class.java)

    override val layoutId: Int
        get() = R.layout.fragment_main

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recycler_story.layoutManager = LinearLayoutManager(activity)
        recycler_story.adapter = MainAdapter {}
        viewModel.stories.observe(this, Observer {
            when (recycler_story.adapter) {
                is MainAdapter -> {
                    (recycler_story.adapter as MainAdapter).submitList(it)
                }
            }
        })
    }
}