package com.example.framgianguyenhotiendat.cleanunittest.base

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.os.IBinder
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.example.framgianguyenhotiendat.cleanunittest.R
import com.example.framgianguyenhotiendat.cleanunittest.util.showLoadingDialog
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment<ViewBinding : ViewDataBinding, ViewModel: BaseViewModel> : Fragment(), LifecycleOwner, BaseNavigator {

    abstract val bindingVariable: Int

    abstract val viewModel: ViewModel

    lateinit var viewDataBinding: ViewBinding

    @get:LayoutRes
    abstract val layoutId: Int

    private var mAlertDialog: AlertDialog? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onAttach(context: Context?) {
        performDependencyInjection()
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.apply {
            setVariable(bindingVariable, viewModel)
            executePendingBindings()
            setLifecycleOwner(this@BaseFragment)
            lifecycle.addObserver(viewModel)
        }
    }

    override fun showLoading() {
        hideLoading()
        mAlertDialog = showLoadingDialog()
    }

    override fun hideLoading() {
        if (mAlertDialog != null && mAlertDialog!!.isShowing) {
            mAlertDialog!!.cancel()
        }
    }

    private fun performDependencyInjection() {
        AndroidSupportInjection.inject(this)
    }
}
