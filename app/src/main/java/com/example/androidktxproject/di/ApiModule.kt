package com.example.androidktxproject.di

import com.example.androidktxproject.retofit.RetrofitBuilder
import com.example.androidktxproject.retofit.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun provideCityListApi(retrofitBuilder: RetrofitBuilder): RetrofitService {
        return retrofitBuilder.buildAPI(RetrofitService::class.java)
    }
}