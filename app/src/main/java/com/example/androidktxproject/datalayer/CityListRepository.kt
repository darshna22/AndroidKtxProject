package com.example.androidktxproject.datalayer

import com.example.androidktxproject.retofit.RetrofitService

class CityListRepository constructor(private val retrofitService: RetrofitService) {
    suspend fun getAllMovies() = retrofitService.getAllCityName()
}