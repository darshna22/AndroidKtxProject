package com.example.androidktxproject.uilayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidktxproject.datalayer.BaseRepository
import com.example.androidktxproject.datalayer.CityListRepository

class MyViewModelFactory <K:BaseRepository> constructor(private val repository: K) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return when(modelClass) {
            CityListViewModel::class.java -> {
                CityListViewModel(this.repository as CityListRepository) as T
            }
            else -> {
                throw IllegalArgumentException("ViewModel Not Found")
            }
        }
    }
}

abstract class AbstractFactory<K> {
    abstract fun create() : K
}

class CityViewModelFactory constructor(private val repository: CityListRepository) : AbstractFactory<CityListViewModel>() {
    override fun create(): CityListViewModel {
        return CityListViewModel(repository)
    }
}

