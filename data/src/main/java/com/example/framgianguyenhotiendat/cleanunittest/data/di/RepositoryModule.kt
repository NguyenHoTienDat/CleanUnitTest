package com.example.framgianguyenhotiendat.cleanunittest.data.di

import com.example.framgianguyenhotiendat.cleanunittest.data.StoryRepositoryImp
import com.example.framgianguyenhotiendat.cleanunittest.domain.repository.StoryRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providerStoryRepository(repository: StoryRepositoryImp): StoryRepository {
        return repository
    }
}
