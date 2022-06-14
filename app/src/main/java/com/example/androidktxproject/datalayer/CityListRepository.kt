package com.example.androidktxproject.datalayer

import com.example.androidktxproject.retofit.RetrofitService
import javax.inject.Inject


class CityListRepository @Inject constructor( val retrofitService: RetrofitService) {
    suspend fun getAllMovies() = retrofitService.getAllCityName()
}