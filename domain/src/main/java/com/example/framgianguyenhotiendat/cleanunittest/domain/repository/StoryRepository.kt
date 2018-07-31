package com.example.framgianguyenhotiendat.cleanunittest.domain.repository

import com.example.framgianguyenhotiendat.cleanunittest.domain.model.Story
import io.reactivex.Single

interface StoryRepository {
    fun getStories(type: String, offset: Int): Single<List<Story>>
}
