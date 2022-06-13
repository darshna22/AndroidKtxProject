package com.example.androidktxproject

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidktxproject.datalayer.CityListRepository
import com.example.androidktxproject.retofit.RetrofitBuilder.getService
import com.example.androidktxproject.uilayer.CityListAdapter
import com.example.androidktxproject.uilayer.CityListViewModel
import com.example.androidktxproject.uilayer.MyViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var cityListAdapter: CityListAdapter
    lateinit var viewModel: CityListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initViewModel()
    }

    private fun initViews() {
        cityListAdapter = CityListAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = cityListAdapter
        }
    }


    private fun initViewModel() {
        viewModel =
            ViewModelProvider(this, MyViewModelFactory(CityListRepository(getService()))).get(
                CityListViewModel::class.java
            )
        //viewModel=ViewModelProviders.of(this@MainActivity, CityListViewModel(CityListRepository(getService()))).get(CityListViewModel::class.java)
        viewModel.callCityListApi()
        viewModel.getCityList().observe(this) {
            it.let {
                progressBar.visibility=View.GONE
                cityListAdapter.getCityListData(it) }
        }

    }
}