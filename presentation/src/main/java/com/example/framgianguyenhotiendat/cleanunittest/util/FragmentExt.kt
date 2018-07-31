package com.example.framgianguyenhotiendat.cleanunittest.util

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.IBinder
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.example.framgianguyenhotiendat.cleanunittest.R

fun Fragment.showLoadingDialog(): AlertDialog =
        AlertDialog.Builder(activity!!).run {
            setView(R.layout.progress_dialog)
            setCancelable(false)
        }.create().apply {
            setCanceledOnTouchOutside(false)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }

fun Fragment.hideKeyboard() {
    val view = activity!!.currentFocus
    if (view != null) {
        dismissKeyboard(view.windowToken)
    }
}

fun Fragment.dismissKeyboard(windowToken: IBinder) {
    val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    imm?.hideSoftInputFromWindow(windowToken, 0)
}

fun Fragment.showKeyboard(editText: EditText?) {
    if (editText == null) return

    val imm = activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    imm?.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
}

fun Fragment.findFragment(TAG: String): Fragment? {
    return activity!!.supportFragmentManager.findFragmentByTag(TAG)
}

fun Fragment.replaceFragment(fragment: Fragment, TAG: String?, addToBackStack: Boolean? = false, transit: Int? = -1) {
    val transaction = activity!!.supportFragmentManager!!.beginTransaction()
            .replace(R.id.container, fragment)

    addToBackStack?.let { if (it) transaction.addToBackStack(TAG) }
    transit?.let { if (it != -1) transaction.setTransition(it) }
    transaction.commit()
}
