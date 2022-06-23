package com.example.androidktxproject.uilayer.activity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.androidktxproject.databinding.CityListRawBinding
import com.example.test.model.CityNameListResponseItem

class CityListAdapter : RecyclerView.Adapter<CityListAdapter.ViewHolder>() {
    var cityList: List<CityNameListResponseItem>? = null
    private lateinit var binding: CityListRawBinding
    fun getCityListData(mCityList: List<CityNameListResponseItem>? = emptyList()) {
        this.cityList = mCityList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = CityListRawBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // sets the text to the textview from our itemHolder class
        val cityNameListResponseItem = cityList?.get(position)
        holder.bind(cityNameListResponseItem?.LocalizedName ?: "")
    }


    override fun getItemCount(): Int {
        return cityList?.size ?: 0
    }


    // Holds the views for adding it to image and text
    class ViewHolder(var binding: CityListRawBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cityName: String) {
            binding.setVariable(BR.mCityName, cityName)
        }
    }

}