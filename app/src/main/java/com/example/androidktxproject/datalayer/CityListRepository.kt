package com.example.androidktxproject.datalayer

import com.example.androidktxproject.retofit.RetrofitService
import com.example.androidktxproject.retofit.result
import javax.inject.Inject


class CityListRepository @Inject constructor( val retrofitService: RetrofitService) {
    suspend fun getAllMovies() = result {
        retrofitService.getAllCityName()
    }
}