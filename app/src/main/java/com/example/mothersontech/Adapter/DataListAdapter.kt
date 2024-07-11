package com.example.mothersontech.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mothersontech.R
import com.example.mothersontech.dataModel.ResponseModel

import com.example.mothersontech.databinding.RecyclerviewAdapterListBinding
import com.squareup.picasso.Picasso

class DataListAdapter(private val dataList : List<ResponseModel> ) : RecyclerView.Adapter<DataListAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding : RecyclerviewAdapterListBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =  RecyclerviewAdapterListBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, @SuppressLint("RecyclerView") position: Int) {

        holder.binding.responseModel = dataList.get(position)
    }


    override fun getItemCount(): Int {
        return dataList.size
    }


}

@BindingAdapter("url")
fun loadImage(view: View,
              url: String?) {
    val image: ImageView = view as ImageView
    Picasso.get()
        .load(url)
        .placeholder(R.drawable.default_image)
        .error(R.drawable.default_image)
        .into(image)
}