package com.example.test.model

class CityNameListResponse : ArrayList<CityNameListResponseItem>()

data class CityNameListResponseItem(
    val EnglishName: String,
    val LocalizedName: String,
)