package com.example.androidktxproject.datalayer

import com.example.androidktxproject.retofit.RetrofitService

abstract class BaseRepository(open val retrofitService: RetrofitService)

class CityListRepository constructor(override val retrofitService: RetrofitService) : BaseRepository(retrofitService) {
    suspend fun getAllMovies() = retrofitService.getAllCityName()
}