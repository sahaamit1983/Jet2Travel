package com.jet2.travel.di

import com.jet2.travel.network.BlogRetrofit
import com.jet2.travel.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        blogRetrofit: BlogRetrofit
    ) : MainRepository {
        return MainRepository(blogRetrofit)
    }
}