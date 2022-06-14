package com.example.androidktxproject.uilayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.androidktxproject.R
import com.example.androidktxproject.databinding.CityListRawBinding
import kotlinx.android.synthetic.main.city_list_raw.view.*

class CityListAdapter : RecyclerView.Adapter<CityListAdapter.ViewHolder>() {
    var cityList: List<String>? = null
    private lateinit var binding: CityListRawBinding
    fun getCityListData(mCityList: List<String> = emptyList()) {
        this.cityList = mCityList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = CityListRawBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        val view =
//            LayoutInflater.from(parent.context).inflate(R.layout.city_list_raw, parent, false)
        return ViewHolder(binding)
    }


    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // sets the text to the textview from our itemHolder class
        holder.bind(cityList?.get(position) ?: "")
    }


    override fun getItemCount(): Int {
        return cityList?.size ?: 0
    }


    // Holds the views for adding it to image and text
    class ViewHolder(var binding: CityListRawBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cityName: String) {
            binding.setVariable(BR.cityName,cityName)
        }
    }

}