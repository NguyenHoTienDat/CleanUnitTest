package com.example.framgianguyenhotiendat.cleanunittest.data.remote.api

import com.example.framgianguyenhotiendat.cleanunittest.data.model.StoryEntity
import com.example.framgianguyenhotiendat.cleanunittest.data.remote.response.WrapperResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StoryApi {
    @GET("{type}.json")
    fun getTopStories(@Path("type") type: String, @Query("offset") offset: Int,
                      @Query("api-key") key : String): Single<WrapperResponse<StoryEntity>>
}
