package com.example.androidktxproject.uilayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidktxproject.R
import kotlinx.android.synthetic.main.city_list_raw.view.*

class CityListAdapter : RecyclerView.Adapter<CityListAdapter.ViewHolder>() {
    var cityList: List<String>? = null

    fun getCityListData(mCityList: List<String> = emptyList()) {
        this.cityList = mCityList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.city_list_raw, parent, false)
        return ViewHolder(view)
    }


    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // sets the text to the textview from our itemHolder class
        holder.textView.text = cityList?.get(position) ?: ""

    }


    override fun getItemCount(): Int {
        return cityList?.size ?: 0
    }


    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

}