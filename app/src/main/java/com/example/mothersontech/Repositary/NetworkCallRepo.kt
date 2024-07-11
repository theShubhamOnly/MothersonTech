package com.example.mothersontech.Repositary

import com.example.mothersontech.dataModel.ResponseModel
import retrofit2.Response

interface NetworkCallRepo {

    suspend fun doNetworkCal() : Response<List<ResponseModel>>
}