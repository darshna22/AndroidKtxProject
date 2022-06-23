package com.example.networklibrary.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RetrofitBuilder @Inject constructor() {
    val baseUrl = "http://dataservice.accuweather.com/locations/v1/"

    fun <T> buildAPI(api: Class<T>): T {
        return getService(api)
    }

    /*This class return api service class instance eg:RetrofitService etc*/
    private fun <T> getService(api: Class<T>): T {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(api)
    }
}