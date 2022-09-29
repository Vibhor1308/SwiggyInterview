package com.example.movieproject.di

import com.example.movieproject.model.remote.ApiClass
import com.example.movieproject.model.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideApiInstance(): ApiClass {
        return ApiClass()
    }

    @Provides
    @Singleton
    fun provideRepository(api:ApiClass):Repository{
        return Repository(api)
    }
}