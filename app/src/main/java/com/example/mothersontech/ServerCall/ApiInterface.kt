package com.example.mothersontech.ServerCall

import com.example.mothersontech.dataModel.ResponseModel
import retrofit2.Response

import retrofit2.http.GET

interface ApiInterface {

    @GET ("/photos")
    suspend fun doNetworkRequest () : Response<List<ResponseModel>>
}