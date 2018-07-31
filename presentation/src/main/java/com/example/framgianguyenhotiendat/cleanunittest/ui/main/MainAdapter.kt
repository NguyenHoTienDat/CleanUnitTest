package com.example.framgianguyenhotiendat.cleanunittest.ui.main

import android.support.v7.util.DiffUtil
import com.example.framgianguyenhotiendat.cleanunittest.R
import com.example.framgianguyenhotiendat.cleanunittest.base.BaseRecyclerAdapter
import com.example.framgianguyenhotiendat.cleanunittest.databinding.ItemStoryBinding
import com.example.framgianguyenhotiendat.cleanunittest.model.StoryItem

class MainAdapter(private val callback: ((StoryItem) -> Unit)?)
    : BaseRecyclerAdapter<StoryItem, ItemStoryBinding>(
        callBack = object : DiffUtil.ItemCallback<StoryItem>() {
            override fun areItemsTheSame(oldItem: StoryItem, newItem: StoryItem): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: StoryItem, newItem: StoryItem): Boolean {
                return oldItem.name == newItem.name
            }

        }
) {
    override fun bind(binding: ItemStoryBinding, item: StoryItem) {
        binding.viewModel = item
    }

    override fun getLayoutRes(): Int = R.layout.item_story
}
