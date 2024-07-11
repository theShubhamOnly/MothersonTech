package com.example.mothersontech.dataModel

import com.example.mothersontech.Repositary.NetworkCallRepo
import com.example.mothersontech.ServerCall.ApiInterface
import retrofit2.Response
import javax.inject.Inject

class NewCallRepoImplementation @Inject constructor(private val apiInterface: ApiInterface) : NetworkCallRepo {
    override suspend fun doNetworkCal(): Response<List<ResponseModel>> {
        return apiInterface.doNetworkRequest()
    }


}