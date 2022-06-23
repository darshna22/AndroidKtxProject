package com.example.androidktxproject.uilayer.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidktxproject.R
import com.example.androidktxproject.databinding.CityListFragmentBinding
import com.example.androidktxproject.uilayer.CityListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.city_list_fragment.*

@AndroidEntryPoint
class CityListFragment : Fragment() {

    lateinit var cityListAdapter: CityListAdapter
    lateinit var binding: CityListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.city_list_fragment, container, false
        )
        binding.lifecycleOwner = this.viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initViewModel()
    }

    private fun initViews() {
        cityListAdapter = CityListAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = cityListAdapter
        }
    }


    private fun initViewModel() {
        // Get a reference to the ViewModel scoped to this Fragment
        val viewModel by viewModels<CityListViewModel>()
        //val viewModel:CityListViewModel by viewModels()
        binding.viewModel = viewModel
        viewModel.cityNameList.observe(activity as MainActivity) {
            it.let {
                //progressBar.visibility = View.GONE
                cityListAdapter.getCityListData(it)
            }
        }

    }
}