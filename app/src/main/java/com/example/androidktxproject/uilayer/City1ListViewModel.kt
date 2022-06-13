package com.example.androidktxproject.uilayer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidktxproject.datalayer.CityListRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.lang.Exception

class City1ListViewModel(val cityListRepository: CityListRepository) : ViewModel() {
    val cityNameList = MutableLiveData<List<String>>()
    val cityListLoadError = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()

    fun getCityList() = cityNameList

    fun callCityListApi() {
        viewModelScope.launch {
            try {
                val data = async { cityListRepository.getAllMovies() }
                val mData = data.await().body()
                val list = mData?.map { value -> value.LocalizedName }
                list.let { cityNameList.postValue(it) }

            } catch (e: Exception) {

            }
        }

    }
}