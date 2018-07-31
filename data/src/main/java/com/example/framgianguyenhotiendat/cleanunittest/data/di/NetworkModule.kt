package com.example.framgianguyenhotiendat.cleanunittest.data.di

import com.example.framgianguyenhotiendat.cleanunittest.data.Constant.BASE_URL
import com.example.framgianguyenhotiendat.cleanunittest.data.Constant.CONNECT_TIMEOUT
import com.example.framgianguyenhotiendat.cleanunittest.data.Constant.READ_TIMEOUT
import com.example.framgianguyenhotiendat.cleanunittest.data.Constant.WRITE_TIMEOUT
import com.example.framgianguyenhotiendat.cleanunittest.data.remote.api.StoryApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        clientBuilder.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        clientBuilder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        return clientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideStoryApi(retrofit: Retrofit): StoryApi = retrofit.create(StoryApi::class.java)
}