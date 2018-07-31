package com.example.framgianguyenhotiendat.cleanunittest.base

import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.recyclerview.extensions.AsyncDifferConfig
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import java.util.concurrent.Executors

abstract class BaseRecyclerAdapter<T, V : ViewDataBinding >(
        callBack: DiffUtil.ItemCallback<T>
) : ListAdapter<T, BaseViewHolder<V>>(
        AsyncDifferConfig.Builder<T>(callBack)
                .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
                .build()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<V> {
        val binding = DataBindingUtil.inflate<V>(
                LayoutInflater.from(parent.context), getLayoutRes(), parent,
                false)
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<V>, position: Int) {
        bind(holder.binding, getItem(position))
        holder.binding.executePendingBindings()
    }

    protected abstract fun bind(binding: V, item: T)

    protected abstract fun getLayoutRes(): Int
}
