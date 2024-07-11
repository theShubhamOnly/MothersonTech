package com.example.mothersontech.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mothersontech.dataModel.ResponseModel
import com.example.mothersontech.Repositary.NetworkCallRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(private val networkCallRepo: NetworkCallRepo) : ViewModel(){

    val dataList : MutableLiveData<Response<List<ResponseModel>>> = MutableLiveData()

    fun getViewModelInformation () {

        viewModelScope.launch {
            dataList.value = networkCallRepo.doNetworkCal()
        }
    }
}