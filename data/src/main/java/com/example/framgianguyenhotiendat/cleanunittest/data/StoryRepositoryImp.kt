package com.example.framgianguyenhotiendat.cleanunittest.data

import com.example.framgianguyenhotiendat.cleanunittest.data.model.StoryEntityMapper
import com.example.framgianguyenhotiendat.cleanunittest.data.remote.api.StoryApi
import com.example.framgianguyenhotiendat.cleanunittest.domain.model.Story
import com.example.framgianguyenhotiendat.cleanunittest.domain.repository.StoryRepository
import io.reactivex.Single
import javax.inject.Inject

class StoryRepositoryImp @Inject constructor(
        private val mStoryApi: StoryApi,
        private val mMapper: StoryEntityMapper
) : StoryRepository {
    override fun getStories(type: String, offset: Int): Single<List<Story>> {
        return mStoryApi.getTopStories(type, offset, "933d86c3e8d54e7bb7fa8ffe6bf0d54f").map {
            mMapper.mapListToDomain(it.results)
        }
    }
}
