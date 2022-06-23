package com.example.androidktxproject.uilayer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidktxproject.utils.NetworkResult
import com.example.androidktxproject.datalayer.CityListRepository
import com.example.androidktxproject.utils.Constants.LOADING_MSG
import com.example.test.model.CityNameListResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityListViewModel @Inject constructor(val cityListRepository: CityListRepository) :
    ViewModel() {
    val cityNameList: LiveData<List<CityNameListResponseItem>?>
        get() = _cityNameList
    private val _cityNameList = MutableLiveData<List<CityNameListResponseItem>?>()
    private var _cityListLoadingErrorMsg = MutableLiveData<String>()
    val cityListLoadingErrorMsg: LiveData<String>
        get() = _cityListLoadingErrorMsg

    private var _cityListLoading = MutableLiveData<Boolean>(false)
    val cityListLoading: LiveData<Boolean>
        get() = _cityListLoading

    init {
        callCityListApi()
    }


    private fun callCityListApi() {
        viewModelScope.launch {
            try {
                val data = cityListRepository.getAllMovies()
                data.collect {
                    when (it) {
                        is NetworkResult.Loading -> {
                            _cityListLoading.value = true
                            _cityListLoadingErrorMsg.value = LOADING_MSG
                        }
                        is NetworkResult.Success -> {
                            val list: List<CityNameListResponseItem>? = it.data
                            _cityNameList.postValue(list)
                            _cityListLoading.value = false

                        }
                        is NetworkResult.Error -> {
                            _cityListLoadingErrorMsg.postValue(it.message)
                        }
                    }
                }
            } catch (e: Exception) {
                _cityListLoadingErrorMsg.postValue(e.message)
            }
        }

    }
}