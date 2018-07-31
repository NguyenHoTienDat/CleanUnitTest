package com.example.framgianguyenhotiendat.cleanunittest.domain.usecase

import com.example.framgianguyenhotiendat.cleanunittest.domain.model.Story
import com.example.framgianguyenhotiendat.cleanunittest.domain.repository.StoryRepository
import io.reactivex.Single
import javax.inject.Inject

open class GetStoriesUseCase @Inject constructor(private val storyRepository: StoryRepository)
    : UseCase<GetStoriesUseCase.Params, Single<List<Story>>>() {
    override fun createObservable(params: Params?): Single<List<Story>> {
        return storyRepository.getStories(params!!.type, params.offset)
    }

    override fun onCleared() {

    }

    data class Params(val type: String, val offset: Int)
}